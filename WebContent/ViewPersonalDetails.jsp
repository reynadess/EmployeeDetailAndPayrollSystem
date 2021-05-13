<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
<title>View Details</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("employeeDetail") == null ){ 
		response.sendRedirect("index.jsp");
	}
	%>
	<h1>Personal Details</h1>
	<form class="home" action="Home" method="post">
		<input class="button" type="submit" value="Home">
	</form>
	<form class="logout" action="Logout" method="post">
		<input class="button" type="submit" value="Logout">
	</form>	<br><br>	
	<form action = "UpdatePersonalDetailsServlet">
		<label class="lable">Employee Name: </label>
		<label style="color: white;font-size: 160%;">${employeeDetail.employeeName}</label>
		<br><br>
		<label class="lable" for="phone">Phone No: </label>
		<label style="color: white;font-size: 160%;">${employeeDetail.phoneNo}</label>
		<br/><br>
		<label class="lable" >Email ID: </label>
		<label style="color: white;font-size: 160%;">${employeeDetail.emailId} </label>
		<br><br>
		<label class="lable">Date of Birth: </label>
		<label style="color: white;font-size: 160%;">${employeeDetail.DOB} </label>		
	</form><br>
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