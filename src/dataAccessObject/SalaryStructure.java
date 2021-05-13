package dataAccessObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
}
