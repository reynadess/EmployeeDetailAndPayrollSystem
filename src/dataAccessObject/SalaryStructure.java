package dataAccessObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import salaryStrucure.Salary;


public class SalaryStructure {
	public static salaryStructureDetails.SalaryStructure getSalaryStructure(){
		salaryStructureDetails.SalaryStructure salaryStructure = new salaryStructureDetails.SalaryStructure();
		String query = "SELECT baseSalary, housingRentAllowance, travellingAllowance, employeeProvidientFund, dearnessAllowance, otherAllowance FROM employee_payroll.salary_percentage;";
		try {
			PreparedStatement preparedStatement = DBConnection.con.prepareStatement(query);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				salaryStructure.setBaseSalary(result.getInt(1));
				salaryStructure.setHousingRentAllowance(result.getInt(2));
				salaryStructure.setTravellingAllowance(result.getInt(3));
				salaryStructure.setEmployeeProvidientFund(result.getInt(4));
				salaryStructure.setDearnessAllowance(result.getInt(5));
				salaryStructure.setOtherAllowance(result.getDouble(6));
			}
			return salaryStructure;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean setSalaryStructure(salaryStructureDetails.SalaryStructure salaryStructure) {
		String query = "UPDATE employee_payroll.salary_percentage SET baseSalary = ?, housingRentAllowance = ?, travellingAllowance = ?, employeeProvidientFund = ?, dearnessAllowance = ?, otherAllowance = ? WHERE salaryId = ?;";
		try {
			PreparedStatement preparedStatement = DBConnection.con.prepareStatement(query);
			preparedStatement.setInt(1, salaryStructure.getBaseSalary());
			preparedStatement.setInt(2, salaryStructure.getHousingRentAllowance());
			preparedStatement.setInt(3, salaryStructure.getTravellingAllowance());
			preparedStatement.setInt(4, salaryStructure.getEmployeeProvidientFund());
			preparedStatement.setInt(5, salaryStructure.getDearnessAllowance());
			preparedStatement.setDouble(6, salaryStructure.getOtherAllowance());
			preparedStatement.setInt(7, 1);
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
	
	public static boolean insertSalary(int employeeId, salaryStrucure.Salary salary) {	
		String query = "INSERT INTO employee_payroll.pay_slip_generation (employeeId, grossBaseSalary, housingRentAllowance, travellingAllowance, employeeProvidientFund, lossOfPay, dearnessAllowance, otherAllowance, finalGrossSalary, finalNetSalary, netBaseSalary) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement preparedStatement = DBConnection.con.prepareStatement(query);
			
			preparedStatement.setInt(1, employeeId);
			preparedStatement.setInt(2, salary.getGrossBaseSalary());
			preparedStatement.setInt(3, salary.getHousingRentAllowance());
			preparedStatement.setInt(4, salary.getTravellingAllowance());
			preparedStatement.setInt(5, salary.getEmployeeProvidientFund());
			preparedStatement.setInt(6, salary.getLossOfPay());
			preparedStatement.setInt(7, salary.getDearnessAllowance());
			preparedStatement.setInt(8, salary.getOtherAllowance());
			preparedStatement.setInt(9, salary.getFinalGrossSalary());
			preparedStatement.setInt(10, salary.getFinalNetSalary());
			preparedStatement.setInt(11, salary.getNetBaseSalary());
			
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
	
	public static Salary getSalary(int employeeId, String startDate, String endDate) {
		Salary salary = new Salary();
		
		String query = "SELECT * FROM employee_payroll.pay_slip_generation WHERE paymentDate BETWEEN ? AND ? AND employeeId = ?;";
		try {
			PreparedStatement preparedStatement = DBConnection.con.prepareStatement(query);
			preparedStatement.setString(1, startDate);
			preparedStatement.setString(2, endDate);
			preparedStatement.setInt(3, employeeId);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				salary.setPaySlipId(result.getInt(2));
				salary.setGrossBaseSalary(result.getInt(3));
				salary.setHousingRentAllowance(result.getInt(4));
				salary.setTravellingAllowance(result.getInt(5));
				salary.setEmployeeProvidientFund(result.getInt(6));
				salary.setLossOfPay(result.getInt(7));
				salary.setDearnessAllowance(result.getInt(8));
				salary.setOtherAllowance(result.getInt(9));
				salary.setFinalGrossSalary(result.getInt(10));
				salary.setFinalNetSalary(result.getInt(11));
				salary.setFinalGrossSalary(result.getInt(12));
				salary.setNetBaseSalary(result.getInt(13));
			}
			return salary;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
}
