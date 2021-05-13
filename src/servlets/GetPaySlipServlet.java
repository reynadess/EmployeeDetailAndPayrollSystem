package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EmployeeDetails.Employee;
import dataAccessObject.DBConnection;
import salaryStructure.Salary;

/**
 * Servlet implementation class GetPaySlipServlet
 */
@WebServlet("/GetPaySlipServlet")
public class GetPaySlipServlet extends HttpServlet {
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
    public GetPaySlipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    static String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String monthYearString = request.getParameter("salaryMonth");
		monthYearString = monthYearString + "-01";
		String date[] = monthYearString.split("-", 0);
		int monthNo = Integer.parseInt(date[1]);
		monthNo--;
		Date monthYear = Date.valueOf(monthYearString);
		
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employeeDetail");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(monthYear);
		calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        calendar.add(Calendar.DATE, -1);  

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date monthEnd = (java.util.Date) calendar.getTime();   
		
        String startDate = sdf.format(monthYear);
        String endDate = sdf.format(monthEnd);
        
        String monthName = getMonthForInt(monthNo);
        
		Salary salary = (dataAccessObject.SalaryStructure.getSalary(employee.getEmployeeId(), startDate, endDate));
		System.out.println(salary);
		salary.setMonth(monthName);
		
		request.setAttribute("salary", salary);
		request.getRequestDispatcher("PaySlipMonth.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
