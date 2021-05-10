<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Employee Detail and Payroll System</title>
</head>
<body>
<%
String status = (String) request.getAttribute("status");
if(status != null) {
	if(status.equals("failed")) {
		out.println("Username or Password Wrong!");
	}
	if(status.equals("inactive")) {
		out.println("You are no more Employee with us!");
	}
}
%>
	<h1>
		Login
	</h1>
	<p  align="center">
		<img src="images/Sample_User_Icon.png" alt="user image" width="150" height="150"><br>
	</p>
	<form action="UserLoginServlet" method="post">
	  <p  align="center">
	  <label for="EmployeeID">Employee ID	:</label>
	  <input type="text" placeholder="Enter Employee ID" name="employeeId"><br><br>
	  <label for="Password">Password	:</label>
	  <input type="password" placeholder="Enter Password" name="password"><br><br>
	  <input type="submit" value="Login">
	  </p>
	</form>		
</body>
</html>