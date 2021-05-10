package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EmployeeDetails.Employee;
import dataAccessObject.UserLoginValidation;
import dataAccessObject.UpdatePassword;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPassword = request.getParameter("currentPassword");
		System.out.println(currentPassword);
		String newPassword = request.getParameter("newPassword");
		System.out.println(currentPassword);
		HttpSession session = request.getSession();
		Employee employePOJO = (Employee) session.getAttribute("employeeDetail");
		int employeeId = employePOJO.getEmployeeId();
		try {
			if(UserLoginValidation.login(employeeId, currentPassword)) {
				if(UpdatePassword.updatePassword(employeeId, newPassword)) {
					request.setAttribute("status", "success");
					request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
				}
				else {
					request.setAttribute("status", "error");
					request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("status", "noPasswordMatch");
				request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
