package dataAccessObject;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class monthWorkingDays {
	public static int getMonthWorkingDays(Date monthYear){
		String query = "SELECT employee_payroll.workingDays FROM employee_payroll.month_working_days WHERE monthYear = ?;";
		int workingDays = 0;
		try {
			PreparedStatement preparedStatement = DBConnection.con.prepareStatement(query);
			preparedStatement.setDate(1, monthYear);
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
	
	public static boolean setMonthWorkingDays(Date monthYear, int workingDays) {
		String query = "INSERT INTO employee_payroll.month_working_days (monthYear, workingDays) VALUES (?, ?);";
		try {
			PreparedStatement preparedStatement = DBConnection.con.prepareStatement(query);
			preparedStatement.setDate(1, monthYear);
			preparedStatement.setInt(2, workingDays);
			int result = preparedStatement.executeUpdate();
			if(result >= 0) {
				System.out.println(result);
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}
}
