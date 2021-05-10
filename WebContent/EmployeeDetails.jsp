<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<h1>Employee Details</h1>
	<p  align="center">
	  <br><br><label for="EmployeeName">Employee Name	:</label>
	  <input type="text" placeholder="Enter Employee Name" name="employeeName"><br><br>
	  <label for="Password">Password	:</label>
	  <input type="password" placeholder="Enter Password" name="password"><br><br>
	  <label for="PhoneNumber">Phone	:</label>
	  <input type="text" placeholder="Enter Phone Number" name="phoneNumber"><br><br>
	  <label for="EmailId">Email ID	:</label>
	  <input type="text" placeholder="Enter Email ID" name="emailID"><br><br>
	  <label for="SalaryCTC">Salary per Annum	:</label>
	  <input type="text" placeholder="Enter Salary per Annum" name="salaryCTC"><br><br>
	  <label for="DOB">Date Of Birth	:</label>
	  <input type="text" placeholder="Enter Date of Birth" name="dob"><br><br>
	  <label for="EmployeeRole">Select Employee Role	:</label>
	  <select name="employeRole">
	  	<option value="Employee">Employee</option>
	  	<option value="Admin">Admin</option>	
	  </select><br><br>
	  <label for="EmployeeStatus">Select Employee Status	:</label>
	  <select name="employeStatus">
	  	<option value="Active">Active</option>
	  	<option value="Inactive">Inactive</option>	
	  </select><br><br>
	  <label for="CreatedBy">Created By	:</label>
	  <input type="text" placeholder="Enter Your Employee Id" name="createdBy"><br><br>
	  <label for="ModifiedBy">Modified By	:</label>
	  <input type="text" placeholder="Enter Your Employee Id" name="modifiedBy"><br><br>
	  <input type="submit" value="Submit">
	 </p>
</body>
</html>