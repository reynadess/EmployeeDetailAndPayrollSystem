package servlets;

import java.io.IOException;
import java.sql.SQLException;

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
import dataAccessObject.EmployeeDetails;
import dataAccessObject.UserLoginValidation;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String password = request.getParameter("password");	
		if(connected == false) {
			request.setAttribute("status", "databaseConnectionFail");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");  
	        rd.forward(request, response);
	    }
		try {
			if(UserLoginValidation.login(employeeId, password)) {
				HttpSession session = request.getSession();
				Employee employeeDetail = EmployeeDetails.getEmployeeDetails(employeeId);
				session.setAttribute("employeeDetail", employeeDetail);
				if(employeeDetail.getEmployeeStatus().equals("active")) {
					request.setAttribute("status", "success");
					if(employeeDetail.getEmployeeRole().equals("Admin")) {
						response.sendRedirect("WelcomeAdmin.jsp");
					}
					else if(employeeDetail.getEmployeeRole().equals("Employee")) {
						response.sendRedirect("WelcomeEmployee.jsp");
					}
				}
				else {
					request.setAttribute("status", "inactive");
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");  
			        rd.forward(request, response);
				}
			}
			else {
				String status = "loginFailed";
				request.setAttribute("status", status);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
				
	}

}