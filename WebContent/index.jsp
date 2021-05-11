<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Detail and Payroll System</title>
</head>
<body>
	<h1>
		Login
	</h1>
	<form>
	<p>
		<img class="image" src="images/Sample_User_Icon" alt="user image" width="150" height="150">
	</p>
	</form><br>
	<form action="UserLoginServlet" method="post">
	  <p>
	  <label for="EmployeeID">Employee ID:</label>
	  <input type="number" name="employeeId" min="1000"><br><br>
	  <label for="Password">Password:</label>
	  <input type="password" name="password"><br><br>
	  <input class="login" type="submit" value="Login">
	  </p>
	</form>		
	<p id = "status" class="status">
	<%
	String status = (String) request.getAttribute("status");
	if(status != null) {
		if(status.equals("loginFailed")) {
			out.println("Username or Password Wrong!");
		}
		else if(status.equals("inactive")) {
			out.println("You are no more Employee with us!");
		}
		else if(status.equals("databaseConnectionFail")) {
			out.println("Connection to database Failed!");
		}
	}
	%>
	</p>
</body>
</html>