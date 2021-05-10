package dataAccessObject;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePassword {
	public static boolean updatePassword(int employeeId, String newPassword) {
		String hashPassword = UserLoginValidation.hashPassword(newPassword);
		String query = "UPDATE employee_payroll.employee SET employeePassword = ? WHERE employeeId = ? ;";
		try {
			PreparedStatement update = DBConnection.con.prepareStatement(query);
			update.setString(1, hashPassword);
			update.setInt(2, employeeId);
			int result = update.executeUpdate();
			if(result >= 0) {
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
