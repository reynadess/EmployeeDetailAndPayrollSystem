package dataAccessObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class UserLoginValidation {
	public static boolean login (int employeeId, String password) throws SQLException {
		if(checkEmployeeId(employeeId)) {
			System.out.println("Employee ID not found!");
			return false;
		}
		String hash = hashPassword(password);
		if(checkPassword(employeeId, hash)) {
			markAttendance(employeeId);
			return true;
		}
		return false;
	}

	private static void markAttendance(int employeeId) {
		String query = "INSERT INTO employee_payroll.attendance (employeeId) VALUES (?);";
		try {
			PreparedStatement preparedStatement = DBConnection.con.prepareStatement(query);
			preparedStatement.setInt(1, employeeId);
			try {
				int result = preparedStatement.executeUpdate();
				if(result > 0)
					System.out.println("Attendance marked!");
			}
			catch(SQLIntegrityConstraintViolationException e) {
				System.out.println("Attendance Already Marked for the day!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	private static boolean checkEmployeeId(int employeeId) {
		String query = "SELECT employeeId FROM employee_payroll.employee WHERE employeeId = ? ;";
		try {
			PreparedStatement checkUser = DBConnection.con.prepareStatement(query);
			checkUser.setInt(1, employeeId);
			ResultSet result = checkUser.executeQuery();
			if(result.next()) {
				return false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	private static boolean checkPassword(int employeeId, String hash) {
		String query = "SELECT employeePassword FROM employee_payroll.employee WHERE employeeId = ? ;";
		try {
			PreparedStatement checkUser = DBConnection.con.prepareStatement(query);
			checkUser.setInt(1, employeeId);
			ResultSet result = checkUser.executeQuery();
			if(result.next()) {
				String hashDB = result.getString(1);
				if(hashDB.equals(hash)) {
					return true;
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}

	static String hashPassword(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(password.getBytes());
		
		byte[] digest = md.digest();
		
		StringBuffer hexString = new StringBuffer();
		
		for(int i = 0; i < digest.length; i++) {
			hexString.append(Integer.toHexString(0xFF & digest[i]));
		}
		String hash = hexString.toString();
		return hash;
	}
}
