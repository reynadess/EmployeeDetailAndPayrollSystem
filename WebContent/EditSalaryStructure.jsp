<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Salary Structure</title>
</head>
<body>
<h1>Update Salary Structure</h1>
<form class="home" action="Home" method="post">
		<input class="button" type="submit" value="Home">
	</form><br>
	<form class="logout" action="Logout" method="post">
		<input class="button" type="submit" value="Logout">
	</form>	<br><br>
	<form action = "SetSalaryStructureServlet" method="post">	
		<label class="lable">Base Salary:</label>
		<input type="number" placeholder="Enter in percentage" name="baseSalary" value="${salaryStructure.baseSalary}" required>
		<br><br>
		<label class="lable">Housing Rent Allowance:</label>
		<input type="number" placeholder="Enter in percentage" name="housingRentAllowance" value="${salaryStructure.housingRentAllowance}" required>
		<br><br>
		<label class="lable">Traveling Allowance:</label>
		<input type="number" placeholder="Enter in percentage" name="travellingAllowance" value="${salaryStructure.travellingAllowance}" required>
		<br><br>
		<label class="lable">Dearness Allowance:</label>
		<input type="number" placeholder="Enter in percentage" name="dearnessAllowance" value="${salaryStructure.dearnessAllowance}" required>
		<br><br>
		<label class="lable">Employee Providient Fund:</label>
		<input type="number" placeholder="Enter in percentage" name="employeeProvidientFund" value="${salaryStructure.employeeProvidientFund}" required>
		<br><br>
		<label class="lable">Others:</label>
		<input type="number" placeholder="Enter in percentage" name="otherAllowance" value="${salaryStructure.otherAllowance}" required>
		<br><br>
		<input class="submit" type="submit" value="Update">
	</form>
	<form action="EditSalaryStructure.jsp" method="post">
		<input class="submit" type="submit" value="Reset">
	</form>	
	<p id = "status" class="status">
	<%
	String status = (String) request.getAttribute("status");
	if(status != null) {
		if(status.equals("success")) {
			out.println("Updated Successfully");
		}
		else if(status.equals("notUpdated")) {
			out.println("Update Failed!");
		}
		else if(status.equals("databaseConnectionFail")) {
			out.println("Connection to database Failed!");
		}
		request.removeAttribute("status");
	}
	%>
	</p>	
</body>
</html>
