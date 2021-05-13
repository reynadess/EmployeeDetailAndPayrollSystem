<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "EmployeeDetails.Employee" %>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("employeeDetail") == null ){ 
		response.sendRedirect("index.jsp");
	}
	else{
		Employee employee = (Employee) session.getAttribute("employeeDetail"); 
		if(employee.getEmployeeRole().equals("Admin") == false){
			request.getRequestDispatcher("Home").forward(request, response);
		}
	}
	%>
	<div id="boxes">
	<h1>Welcome ${employeeDetail.employeeName}</h1><br>
	<form class="logout" action="Logout" method="post">
		<input class="button" type="submit" value="Logout">
	</form><br><br>
	<div id = "leftbox">
	<form class="horizontal" action="RegisterEmployee.jsp" method="post">
		<input  type="submit" value="Register Employee">
	</form>
	
	<form class="horizontal" action="ViewEmployee.jsp" method="post">
		<input type="submit" value="View Employee Details">
	</form>
	<form class="horizontal" action="UpdateEmployee.jsp" method="post">
		<input type="submit" value="Update Employee Details">
	</form>
	<form class="horizontal" action="EditSalaryStructure.jsp" method="post">
		<input type="submit" value="Update Salary Structure">
	</form>
	<form class="horizontal" action="PaySlipGeneration.jsp" method="post">
		<input type="submit" value="Generate Pay Slip for Employees">
	</form><br><br><br><br><br><br>	
	</div>
	<div id = "rightbox">
	<form class="horizontal" action="ViewPersonalDetails.jsp" method="post">
		<input type="submit" value="View Personal Details">
	</form>
	<form class="horizontal" action="UpdatePersonalDetails.jsp" method="post">
		<input type="submit" value="Update Personal Details">
	</form>
	<form class="horizontal" action="ChangePassword.jsp" method="post">
		<input type="submit" value="Change Password">
	</form>
	
	<form class="horizontal"  action="PaySlipMonth.jsp" method="post">
		<input type="submit" value="View Personal Pay Slip">
	</form>
	</div>
	</div>
</body>
</html>