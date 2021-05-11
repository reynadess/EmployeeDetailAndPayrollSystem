<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Password Change</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("employeeDetail") == null ){ 
		response.sendRedirect("index.jsp");
	}
	%>
	<h1>Change Password</h1>
	<form action = "ChangePasswordServlet" method="post">
		<label for="Current Password">Current Password:</label>
		<input type="password" name="currentPassword">
		<label for="New Password">New Password:</label>
	  	<input type="password" name="newPassword">
		<input type="submit" value="Submit">		
	</form>
	<p id = "status">
	<%
	String status = (String) request.getAttribute("status");
	if(status != null) {
		if(status.equals("noPasswordMatch")) {
			out.println("Current Password Wrong");
		}
		else if(status.equals("error")) {
			out.println("Password not changed! Try again later.");
		}
		else if(status.equals("success")) {
			out.println("Changed Password Successfully");
		}
	}
	%>
	</p>
	<br>
	<form action="Home" method="post">
		<input type="submit" value="Home">
	</form>
	<form action="Logout" method="post">
		<input type="submit" value="Logout">
	</form>	
</body>
</html>