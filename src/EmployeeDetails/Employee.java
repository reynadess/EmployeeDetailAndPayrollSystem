package EmployeeDetails;

import java.sql.Date;

public class Employee {
	int employeeId;
	String employeeName;
	String employeeRole;
	Date DOB;
	int totalSalary;
	String phoneNo;
	String emailId;
	String employeeStatus;
	
	public Employee() {
	}
	
	public Employee(int id, String name, String role, Date dob, int totalSalary2, String phone, String email, String employeeStatus) {
		this.employeeId = id;
		this.employeeName = name;
		this.employeeRole = role;
		this.DOB = dob;
		this.totalSalary = totalSalary2;
		this.phoneNo = phone;
		this.emailId = email;
		this.employeeStatus = employeeStatus;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public int getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
}
