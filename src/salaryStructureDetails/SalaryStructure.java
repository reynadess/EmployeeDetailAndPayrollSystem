package salaryStructureDetails;

public class SalaryStructure {
	int baseSalary;
	int housingRentAllowance;
	int travellingAllowance;
	int employeeProvidientFund;
	int dearnessAllowance;
	double otherAllowance;
	
	public SalaryStructure() {
		
	}
	
	public SalaryStructure(int bs, int hra, int tra, int epf, int da, double oa) {
		this.baseSalary = bs;
		this.housingRentAllowance = hra;
		this.travellingAllowance = tra;
		this.employeeProvidientFund = epf;
		this.dearnessAllowance = da;
		this.otherAllowance = oa;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}

	public int getHousingRentAllowance() {
		return housingRentAllowance;
	}

	public void setHousingRentAllowance(int housingRentAllowance) {
		this.housingRentAllowance = housingRentAllowance;
	}

	public int getTravellingAllowance() {
		return travellingAllowance;
	}

	public void setTravellingAllowance(int travellingAllowance) {
		this.travellingAllowance = travellingAllowance;
	}

	public int getEmployeeProvidientFund() {
		return employeeProvidientFund;
	}

	public void setEmployeeProvidientFund(int employeeProvidientFund) {
		this.employeeProvidientFund = employeeProvidientFund;
	}

	public int getDearnessAllowance() {
		return dearnessAllowance;
	}

	public void setDearnessAllowance(int dearnessAllowance) {
		this.dearnessAllowance = dearnessAllowance;
	}

	public double getOtherAllowance() {
		return otherAllowance;
	}

	public void setOtherAllowance(double otherAllowance) {
		this.otherAllowance = otherAllowance;
	}
}
