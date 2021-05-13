package salaryCalculation;

import java.sql.Date;
import java.util.ArrayList;

import EmployeeDetails.Employee;
import EmployeeDetails.EmployeeSalary;
import dataAccessObject.Attendance;
import dataAccessObject.EmployeeDetails;
import salaryStructureDetails.SalaryStructure;
import salaryStrucure.Salary;

public class SalaryCalculation {

	public static boolean calculateSalary(SalaryStructure salaryPercentage, Date monthYear, int workingDays) {
		ArrayList<EmployeeSalary> employeeDetails = EmployeeDetails.getEmployeeDetails();
		for(int i = 0; i < employeeDetails.size(); i++) {
			int presentDays = Attendance.getEmployeeAttendance(employeeDetails.get(i).getEmployeeId(), monthYear);
			double basePercentage = salaryPercentage.getBaseSalary();
			double salaryMonth = (employeeDetails.get(i).getSalaryAnnum() / 12);
			double grossBaseSalary = ((basePercentage / 100) * (salaryMonth));
			double baseSalaryDay = (grossBaseSalary / workingDays);
			double netBaseSalary = (presentDays * baseSalaryDay);
			double hraPercentage = (int) salaryPercentage.getHousingRentAllowance();
			double hraSalary = ((hraPercentage / 100) * netBaseSalary);
			double taPercentage = (int) (salaryPercentage.getTravellingAllowance());
			double taSalary = ((taPercentage / 100) * netBaseSalary);
			double daPercentage = (int) (salaryPercentage.getDearnessAllowance());
			double daSalary = ((daPercentage / 100) * netBaseSalary);
			double epfPercentage = (int) (salaryPercentage.getEmployeeProvidientFund());
			double epfSalary = ((epfPercentage / 100) * netBaseSalary);
			double othersPercentage = (salaryPercentage.getOtherAllowance());
			double otherSalary = ((othersPercentage / 100) * netBaseSalary);
			long finalGrossSalary = Math.round(netBaseSalary + hraSalary + taSalary + daSalary + epfSalary + otherSalary);
			long finalNetSalary = Math.round((netBaseSalary + hraSalary + taSalary + daSalary) - (epfSalary + otherSalary));
			double lossOfPay = grossBaseSalary - netBaseSalary;
			
			Salary salary = new Salary();
			salary.setGrossBaseSalary((int)Math.round(grossBaseSalary));
			salary.setNetBaseSalary((int)Math.round(netBaseSalary));
			salary.setHousingRentAllowance((int)Math.round(hraSalary));
			salary.setTravellingAllowance((int)Math.round(taSalary));
			salary.setDearnessAllowance((int)Math.round(daSalary));
			salary.setEmployeeProvidientFund((int)Math.round(epfSalary));
			salary.setOtherAllowance((int)Math.round(otherSalary));
			salary.setLossOfPay((int)Math.round(lossOfPay));
			salary.setFinalGrossSalary((int)Math.round(finalGrossSalary));
			salary.setFinalNetSalary((int)Math.round(finalNetSalary));
			
			dataAccessObject.SalaryStructure.insertSalary(employeeDetails.get(i).getEmployeeId(), salary);
		}
		return true;
	}
}
