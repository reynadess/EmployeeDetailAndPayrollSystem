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
	<form action = "" method="post">	
		<label class="lable">Base Salary:</label>
		<input type="number" placeholder="Enter in percentage" name="baseSalary" required>
		<br><br>
		<label class="lable">Housing Rent Allowance:</label>
		<input type="number" placeholder="Enter in percentage" name="housingRentAllowance" required>
		<br><br>
		<label class="lable">Traveling Allowance:</label>
		<input type="number" placeholder="Enter in percentage" name="travellingAllowance" required>
		<br><br>
		<label class="lable">Dearness Allowance:</label>
		<input type="number" placeholder="Enter in percentage" name="dearnessAllowance" required>
		<br><br>
		<label class="lable">Employee Provident Fund:</label>
		<input type="number" placeholder="Enter in percentage" name="employeeProvidientFund" required>
		<br><br>
		<label class="lable">Others:</label>
		<input type="number" placeholder="Enter in percentage" name="otherAllowance" required>
		<br><br>
		<input class="submit" type="submit" value="Update">
	</form>

</body>
</html>