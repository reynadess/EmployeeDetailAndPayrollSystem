package dataAccessObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import EmployeeDetails.Employee;

public class EmployeeDetails {
	public static Employee getEmployeeDetails(int employeeId) {
		String employeeName = null;
		String employeeRole = null;
		Date DOB = null;
		int totalSalary = 0;
		String phoneNo = null;
		String emailId = null;
		String employeeStatus = null;
		String query = "SELECT employeeName, employeeRole, DOB, totalSalary, phoneNo, emailId, employeeStatus FROM employee_payroll.employee WHERE employeeId = ? ;";
		try {
			PreparedStatement checkUser = DBConnection.con.prepareStatement(query);
			checkUser.setInt(1, employeeId);
			ResultSet result = checkUser.executeQuery();
			while(result.next()) {
				employeeName = result.getString(1);
				employeeRole = result.getString(2);
				DOB = result.getDate(3);
				totalSalary = result.getInt(4);
				phoneNo = result.getString(5);
				emailId = result.getString(6);
				employeeStatus = result.getString(7);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		Employee EmployeeDetail = new Employee(employeeId, employeeName, employeeRole, DOB, totalSalary, phoneNo, emailId, employeeStatus);
		return EmployeeDetail;
	}
}
