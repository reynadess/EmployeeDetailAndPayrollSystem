<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
<title>Update Details</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("employeeDetail") == null ){ 
		response.sendRedirect("index.jsp");
	}
	%>
	<h1>Update Personal Details</h1>
	<form class="home" action="Home" method="post">
		<input class="button" type="submit" value="Home">
	</form><br>
	<form class="logout" action="Logout" method="post">
		<input class="button" type="submit" value="Logout">
	</form>	<br><br>	
	<form action = "UpdatePersonalDetailsServlet" method="post">
		<label>Employee Name:</label>
		<input type="text" name="employeeName" value="${employeeDetail.employeeName}" required>
		<br><br>
		<label>Date of Birth:</label>
	  	<input type="date" name="DOB" value="${employeeDetail.DOB}"/>
	  	<br><br>
		<label for="phone">Phone No:</label>
		<input type="tel" id="phone" name="phoneNo" placeholder="**********" value="${employeeDetail.phoneNo}" pattern="[0-9]{10}" required>
		<br/><br>
		<label>Email ID:</label>
		<input type="email" name="emailId" value= "${employeeDetail.emailId}" required>
		<br><br>
		<input class="submit" type="submit" value="Update">		
	</form><br>
		<form action="UpdatePersonalDetails.jsp" method="post">
		<input class="submit" type="submit" value="Reset">
	</form>
	<p id = "status" class="status">
	<%
	String status = (String) request.getAttribute("status");
	if(status != null) {
		if(status.equals("success")) {
			out.println("Details Updated Successfully");
		}
		else if(status.equals("loginFailed")) {
			out.println("Username or Password Wrong!");
		}
		else if(status.equals("inactive")) {
			out.println("You are no more Employee with us!");
		}
		else if(status.equals("databaseConnectionFail")) {
			out.println("Connection to database Failed!");
		}
		request.removeAttribute("status");
	}
	%>
	</p>	
</body>
</html>