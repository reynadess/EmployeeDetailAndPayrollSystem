<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Fetch Employee</h1>
	<br><br><label for="Option">Select Option to Enter	:</label>
	  <select name="optionSelected">
	  	<option value="employeeId">EmployeeId</option>
	  	<option value="employeeName">EmployeeName</option>
	  	<option value="employeePhone">EmployeePhone</option>
	  	<option value="employeeEmail">EmployeeEmail</option>	
	  </select><br><br>
	  <label>Enter the details	:</label>
	 <input type="text" placeholder="Enter selected details" name="detailEntered"><br><br>
	 <input type="submit" value="Submit">
</body>
</html>