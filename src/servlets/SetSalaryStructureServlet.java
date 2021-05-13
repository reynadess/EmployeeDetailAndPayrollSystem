package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataAccessObject.DBConnection;
import salaryStructureDetails.SalaryStructure;

@WebServlet("/SetSalaryStructureServlet")
public class SetSalaryStructureServlet extends HttpServlet {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(connected == false) {
			request.setAttribute("status", "databaseConnectionFail");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");  
	        rd.forward(request, response);
	    }
		
		HttpSession session = request.getSession();
		
		salaryStructureDetails.SalaryStructure salaryStructure = (salaryStructureDetails.SalaryStructure) session.getAttribute("salaryStructure");
		System.out.println(salaryStructure);
		salaryStructure.setBaseSalary(Integer.parseInt(request.getParameter("baseSalary")));
		salaryStructure.setHousingRentAllowance(Integer.parseInt(request.getParameter("housingRentAllowance")));
		salaryStructure.setTravellingAllowance(Integer.parseInt(request.getParameter("travellingAllowance")));
		salaryStructure.setDearnessAllowance(Integer.parseInt(request.getParameter("dearnessAllowance")));
		salaryStructure.setEmployeeProvidientFund(Integer.parseInt(request.getParameter("employeeProvidientFund")));
		salaryStructure.setOtherAllowance(Double.parseDouble(request.getParameter("otherAllowance")));
		if(dataAccessObject.SalaryStructure.setSalaryStructure(salaryStructure)) 	{
			request.setAttribute("status", "success");
		}
		else {
			request.setAttribute("status", "notUpdated");
		}
		request.getRequestDispatcher("EditSalaryStructure.jsp").forward(request, response);
	}
}
