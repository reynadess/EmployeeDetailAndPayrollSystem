package dataAccessObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import EmployeeDetails.Employee;

import dataAccessObject.UserLoginValidation;
public class EmployeeDetails {
	
	public static boolean createEmployeeDetails(Employee employee, String password, Employee currentEmployee) {
		String query = "INSERT INTO employee_payroll.employee(employeeName, employeePassword, employeeRole, DOB, totalSalary, phoneNo, emailId, employeeStatus, createdBy) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement preparedStatement = DBConnection.con.prepareStatement(query);
			preparedStatement.setString(1, employee.getEmployeeName());
			preparedStatement.setString(2, UserLoginValidation.hashPassword(password));
			preparedStatement.setString(3, employee.getEmployeeRole());
			preparedStatement.setDate(4, (java.sql.Date) employee.getDOB());
			preparedStatement.setInt(5, employee.getTotalSalary());
			preparedStatement.setString(6, employee.getPhoneNo());
			preparedStatement.setString(7, employee.getEmailId());
			preparedStatement.setString(8, employee.getEmployeeStatus());
			preparedStatement.setInt(9, currentEmployee.getEmployeeId());
			int result = preparedStatement.executeUpdate();
			if(result >= 0) {
				System.out.println("Updated!");
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}	
		return false;
	}
	
	public static boolean setEmployeeDetails(Employee employee, Employee currentEmployee) {
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
		
		String query = "UPDATE employee_payroll.employee SET employeeName = ?, employeeRole = ?, DOB = ?, totalSalary = ?, phoneNo = ?, emailId = ?, employeeStatus = ?, modifiedOn = ?, modifiedBy = ? WHERE employeeId = ?;";
		try {
			PreparedStatement preparedStatement = DBConnection.con.prepareStatement(query);
			preparedStatement.setString(1, employee.getEmployeeName());
			preparedStatement.setString(2, employee.getEmployeeRole());
			preparedStatement.setDate(3, (java.sql.Date) employee.getDOB());
			preparedStatement.setInt(4, employee.getTotalSalary());
			preparedStatement.setString(5, employee.getPhoneNo());
			preparedStatement.setString(6, employee.getEmailId());
			preparedStatement.setString(7, employee.getEmployeeStatus());
			preparedStatement.setTimestamp(8, sqlTime);
			preparedStatement.setInt(9, currentEmployee.getEmployeeId());
			preparedStatement.setInt(10, employee.getEmployeeId());
			int result = preparedStatement.executeUpdate();
			if(result >= 0) {
				System.out.println("Updated!");
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}	
		return false;
	}
	
	
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
		Employee EmployeeDetail = new Employee(employeeId, employeeName, employeeRole, (java.sql.Date) DOB, totalSalary, phoneNo, emailId, employeeStatus);
		return EmployeeDetail;
	}
}
