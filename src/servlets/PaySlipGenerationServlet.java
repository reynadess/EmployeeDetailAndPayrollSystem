package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Date;

import dataAccessObject.DBConnection;
import dataAccessObject.monthWorkingDays;

/**
 * Servlet implementation class PaySlipGenerationServlet
 */
@WebServlet("/PaySlipGenerationServlet")
public class PaySlipGenerationServlet extends HttpServlet {
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
    public PaySlipGenerationServlet() {
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
		String monthYearString = request.getParameter("salaryMonth");
		monthYearString = monthYearString + "-01";
		int workingDays = Integer.parseInt(request.getParameter("workingDays"));
		System.out.println(monthYearString + " " + workingDays);
		Date monthYear = Date.valueOf(monthYearString);
		if(monthWorkingDays.setMonthWorkingDays(monthYear, workingDays)) {
			request.setAttribute("status", "success");
		}
		else {
			request.setAttribute("status", "failed");
		}
		request.getRequestDispatcher("PaySlipGeneration.jsp").forward(request, response);
	}

}
