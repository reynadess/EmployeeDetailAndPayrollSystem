<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
	<br><br><label>Enter the number of working days	:</label>
	<form action="PaySlipGenerationServlet" method="post">
		<label for="Month">Month:</label>
		<input type="month" name="salaryMonth">
		<label for="Working Days">Number of working days:</label>
	  	<input type="number" name="workingDays" min="0" max="40">
		<input type="submit" value="Submit">
	</form>
</body>
</html>