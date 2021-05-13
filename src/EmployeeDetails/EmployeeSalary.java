package EmployeeDetails;

public class EmployeeSalary {
	int employeeId;
	int salaryAnnum;
	public EmployeeSalary(int id, int salary) {
		this.employeeId = id;
		this.salaryAnnum = salary;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getSalaryAnnum() {
		return salaryAnnum;
	}
	public void setSalaryAnnum(int salaryAnnum) {
		this.salaryAnnum = salaryAnnum;
	}
}
