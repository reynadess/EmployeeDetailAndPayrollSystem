package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EmployeeDetails.Employee;
import dataAccessObject.DBConnection;
import dataAccessObject.EmployeeDetails;

@WebServlet("/GetEmployeeDetailsServlet")
public class GetEmployeeDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	boolean connected = false;
	
    public GetEmployeeDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
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
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(connected == false) {
			request.setAttribute("status", "databaseConnectionFail");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");  
	        rd.forward(request, response);
	    }
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		Employee getEmployee = EmployeeDetails.getEmployeeDetails(employeeId);
		if(getEmployee.getEmployeeName() == null) {
			request.setAttribute("status", "notFound");
			request.getRequestDispatcher("UpdateEmployee.jsp").forward(request, response);
		}
		System.out.println(getEmployee);
		request.setAttribute("getEmployee", getEmployee);
		request.getRequestDispatcher("UpdateEmployee.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
