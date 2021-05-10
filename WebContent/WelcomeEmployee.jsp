<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<<<<<<< HEAD
<title>Employee</title>
=======
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome Employee</title>
>>>>>>> branch 'master' of https://github.com/reynadess/EmployeeDetailAndPayrollSystem.git
</head>
<body>
<<<<<<< HEAD
	<h1>Welcome Employee</h1>
	<p  align="center">
	<br><br><br><br><input type="submit" value="Fetch Personal Details"><br><br>
	<input type="submit" value="Update Personal Details"><br><br>
	<input type="submit" value="Get Pay Slip"><br><br>
	</p>
	<div align="right">
		<input  type="submit" value="Logout">
	</div>
=======
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("employeeDetail") == null ){ 
		response.sendRedirect("index.jsp");
	}
	%>
	<h1>Welcome ${employeeDetail.employeeName}</h1>
	<form action="PaySlipEmployee" method="post">
		<input type="submit" value="Pay Slip">
	</form>
	<form action="ChangePassword" method="post">
		<input type="submit" value="Change Password">
	</form>
	<form action="Logout" method="post">
		<input type="submit" value="Logout">
	</form>
	<form action="RegisterEditEmployee" method="post">
		<input type="submit" value="Edit Employee">
	</form>
>>>>>>> branch 'master' of https://github.com/reynadess/EmployeeDetailAndPayrollSystem.git
</body>
</html>