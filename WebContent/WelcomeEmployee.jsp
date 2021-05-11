<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Employee</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome Employee</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("employeeDetail") == null ){ 
		response.sendRedirect("index.jsp");
	}
	%>
	<h1>Welcome ${employeeDetail.employeeName}</h1>
	<form class="logout" action="Logout" method="post">
	<input class="button" type="submit" value="Logout">
	</form><br>
	<form action="PaySlipEmployee" method="post">
		<input type="submit" value="View Pay Slip">
	</form><br><br>
	<form action="ChangePassword.jsp" method="post">
		<input type="submit" value="Change Password">
	</form><br><br>
	<form action="UpdatePersonalDetails" method="post">
		<input type="submit" value="Update Personal Details">
	</form>
</body>
</html>