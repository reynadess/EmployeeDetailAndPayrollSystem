<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<<<<<<< HEAD
<title>Admin</title>
=======
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Page</title>
>>>>>>> branch 'master' of https://github.com/reynadess/EmployeeDetailAndPayrollSystem.git
</head>
<body>
<<<<<<< HEAD
	<h1>
		Welcome Admin
	</h1>
	<p  align="center">
	<br><br><br><br><input  type="submit" value="Register Employee Details"><br><br>
	<input type="submit" value="Fetch Employee Details"><br><br>
	<input type="submit" value="Update Employee Details"><br><br>
	<input type="submit" value="Generate Pay Slip"><br><br>
	</p>
	<div align="right">
	<input type="submit" value="Logout">
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
	<input type="submit" value="Register Employee">
</form>
<form action="RegisterEditEmployee" method="post">
	<input type="submit" value="Edit Employee">
</form>
<form action="EditSalaryStructure" method="post">
	<input type="submit" value="Edit Salary Structure">
</form>
<form action="PaySlipGeneration" method="post">
	<input type="submit" value="Generate Pay Slip for Employees">
</form>
>>>>>>> branch 'master' of https://github.com/reynadess/EmployeeDetailAndPayrollSystem.git
</body>
</html>