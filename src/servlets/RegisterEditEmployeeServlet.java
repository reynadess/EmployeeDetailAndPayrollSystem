package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EmployeeDetails.Employee;

@WebServlet("/RegisterEditEmployeeServlet")
public class RegisterEditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee employeePOJO = (Employee) session.getAttribute("employeeDetail");
		employeePOJO.setEmployeeName(request.getParameter("employeeName"));
		Date date = Date.valueOf(request.getParameter("DOB"));
		employeePOJO.setDOB(date);
		employeePOJO.setPhoneNo(request.getParameter("phoneNo"));
		employeePOJO.setEmailId(request.getParameter("emailId"));
		if(dataAccessObject.EmployeeDetails.setEmployeeDetails(employeePOJO, employeePOJO)) {
			request.setAttribute("status", "success");
		}
		else {
			request.setAttribute("status", "failed");
		}
		request.getRequestDispatcher("RegisterEditEmployee.jsp").forward(request, response);
	}

}
