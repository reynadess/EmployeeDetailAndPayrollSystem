package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EmployeeDetails.Employee;
import dataAccessObject.EmployeeDetails;

@WebServlet("/GetEmployeeDetailsServlet")
public class GetEmployeeDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetEmployeeDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		Employee getEmployee = EmployeeDetails.getEmployeeDetails(employeeId);
		if(getEmployee.getEmployeeName() == null) {
			request.setAttribute("status", "notFound");
			request.getRequestDispatcher("RegisterEditEmployee.jsp").forward(request, response);
		}
		System.out.println(getEmployee);
		request.setAttribute("getEmployee", getEmployee);
		request.getRequestDispatcher("RegisterEditEmployee.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
