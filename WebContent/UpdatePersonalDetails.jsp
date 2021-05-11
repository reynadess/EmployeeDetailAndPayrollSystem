<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>UpdateDeatils</title>
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
	<form action = "EditEmployeeDetails" method="post">
		<label>Employee Name:</label>
		<input type="text" name="employeeName" value=${employeeDetail.employeeName} required>
		<br><br>
		<label>Date of Birth:</label>
	  	<input type="date" name="DOB" <fmt:formatDate value="${employeeDetail.DOB}"/>/>
	  	<br><br>
		<label for="phone">Phone No:</label>
		<input type="tel" id="phone" name="phoneNo" placeholder="1234567890" value=${employeeDetail.phoneNo} pattern="[0-9]{10}" required>
		<br/><br>
		<label>Email ID:</label>
		<input type="text" name="emailId" value= ${employeeDetail.emailId} required>
		<br><br>
		<input class="submit" type="submit" value="Edit">
		<button onclick='location.reload()'>Reset</button>		
	</form>
</body>
</html>