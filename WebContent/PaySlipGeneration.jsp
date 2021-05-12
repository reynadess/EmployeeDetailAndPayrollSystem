<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Pay Slip</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("employeeDetail") == null ){ 
		response.sendRedirect("index.jsp");
	}
	%>
	<h1>Pay Slip Generation</h1>
	<form class="home" action="Home" method="post">
		<input class="button" type="submit" value="Home">
	</form><br>
	<form class="logout" action="Logout" method="post">
		<input class="button" type="submit" value="Logout">
	</form>	<br><br>
	<form action="PaySlipGenerationServlet" method="post">
		<label for="Month">Select the month to generate pay slip	:</label>
		<input type="month" name="salaryMonth"><br><br>
		<label class="lable" for="Working Days">No.of working days:</label>
	  	<input type="number" name="workingDays" min="0" max="31"><br><br>
		<input class="submit" type="submit" value="Submit">
	</form>
</body>
</html>