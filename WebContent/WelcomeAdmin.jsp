<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if(session.getAttribute("employeeDetail") == null ){ 
	response.sendRedirect("index.jsp");
}
%>
<h1 >Welcome ${employeeDetail.employeeName}</h1><br>
<form class="logout" action="Logout" method="post">
	<input class="button" type="submit" value="Logout">
</form><br>
<form  action="PaySlipEmployee.jsp" method="post">
	<input type="submit" value="View Pay Slip">
</form><br>
<form action="RegisterEditEmployee.jsp" method="post">
	<input  type="submit" value="Register Employee">
</form><br>
<form action="RegisterEditEmployee.jsp" method="post">
	<input type="submit" value="Update Employee">
</form><br>
<form  action="ChangePassword.jsp" method="post">
	<input type="submit" value="Change Password">
</form><br>
<form  action="EditSalaryStructure" method="post">
	<input type="submit" value="Update Salary Structure">
</form><br>
<form  action="PaySlipGeneration.jsp" method="post">
	<input type="submit" value="Generate Pay Slip for Employees">
</form><br><br>
</body>
</html>