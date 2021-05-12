package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EmployeeDetails.Employee;
import dataAccessObject.DBConnection;


@WebServlet("/SetEmployeeDetailsServlet")
public class SetEmployeeDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	boolean connected = false;

	public void init(ServletConfig config) throws ServletException {
		if(DBConnection.makeConnection()) {
			connected = true;
			System.out.println("Connection to database created");
		}
		else {
			System.out.println("Failed to connect to Database");
			
		}
	}
	
	public void destroy(ServletConfig config) throws ServletException {
		if(connected) {
			DBConnection.destroyConnection();
		}
	}
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetEmployeeDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee setEmployee = new Employee();
		if(connected == false) {
			request.setAttribute("status", "databaseConnectionFail");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");  
	        rd.forward(request, response);
	    }
		setEmployee.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		setEmployee.setEmployeeName(request.getParameter("employeeName"));
		java.sql.Date DOB = Date.valueOf(request.getParameter("DOB"));
		setEmployee.setDOB(DOB);
		setEmployee.setPhoneNo(request.getParameter("phoneNo"));
		setEmployee.setEmailId(request.getParameter("emailId"));
		setEmployee.setTotalSalary(Integer.parseInt(request.getParameter("totalSalary")));
		setEmployee.setEmployeeRole(request.getParameter("employeeRole"));
		setEmployee.setEmployeeStatus(request.getParameter("employeeStatus"));
		HttpSession session = request.getSession();
		Employee employeePOJO = (Employee) session.getAttribute("employeeDetail");
		if(dataAccessObject.EmployeeDetails.setEmployeeDetails(setEmployee, employeePOJO)) {
			request.setAttribute("status", "success");
		}
		else {
			request.setAttribute("status", "failed");
		}
		request.getRequestDispatcher("UpdateEmployee.jsp").forward(request, response);		
	}
}