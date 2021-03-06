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
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("employeeDetail") != null ){ 
		request.getRequestDispatcher("Home").forward(request, response);
	}
	%>
	<h1>
		Employee Detail and Payroll System
	</h1>
	<form>
	
	<p>
		<img class="image" src="images/Sample_User_Icon" alt="user image" width="150" height="150">
	</p>
	<h2> Login</h2><br>
	</form>
	<form action="UserLoginServlet" method="post">
	  <p>
	  <label class="lable" for="EmployeeID">Employee ID:</label>
	  <input type="number" name="employeeId" min="1000" required><br><br>
	  <label class="lable" for="Password">Password:</label>
	  <input type="password" name="password" required><br><br>
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