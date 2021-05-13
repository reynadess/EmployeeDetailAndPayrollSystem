package dataAccessObject;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Attendance {
	public static int getEmployeeAttendance(int employeeId, Date monthStart) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(monthStart);
		calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        calendar.add(Calendar.DATE, -1);  

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date monthEnd = (java.util.Date) calendar.getTime();   
		
        String startDate = sdf.format(monthStart);
        String endDate = sdf.format(monthEnd);
        
        int workingDays = 0;
		String query = "SELECT COUNT(employeeId) FROM employee_payroll.attendance WHERE loginDate BETWEEN ? AND ? AND employeeId = ?;";
		try {
			PreparedStatement preparedStatement = DBConnection.con.prepareStatement(query);
			preparedStatement.setString(1, startDate);
			preparedStatement.setString(2, endDate);
			preparedStatement.setInt(3, employeeId);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				workingDays = result.getInt(1);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return workingDays;
	}
}
