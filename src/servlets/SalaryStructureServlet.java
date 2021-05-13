package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataAccessObject.DBConnection;
import dataAccessObject.SalaryStructure;
/**
 * Servlet implementation class SalaryStructureServlet
 */
@WebServlet("/SalaryStructureServlet")
public class SalaryStructureServlet extends HttpServlet {
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
    public SalaryStructureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(connected == false) {
			request.setAttribute("status", "databaseConnectionFail");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");  
	        rd.forward(request, response);
	    }
		salaryStructureDetails.SalaryStructure salaryStructure = dataAccessObject.SalaryStructure.getSalaryStructure();
		HttpSession session = request.getSession();
		if(salaryStructure != null) {
			session.setAttribute("salaryStructure", salaryStructure);
		}
		else {
			request.setAttribute("status", "failed");
		}
		RequestDispatcher rd = request.getRequestDispatcher("EditSalaryStructure.jsp");  
        rd.forward(request, response);		
	}

}
