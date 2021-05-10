package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EmployeeDetails.Employee;


@WebServlet("/Home")
public class Home extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		Employee employeePOJO = (Employee) session.getAttribute("employeeDetail");
		if(employeePOJO.getEmployeeRole().equals("Admin")) {
			response.sendRedirect("WelcomeAdmin.jsp");
		}
		else {
			response.sendRedirect("WelcomeEmployee.jsp");			
		}
	}

}
