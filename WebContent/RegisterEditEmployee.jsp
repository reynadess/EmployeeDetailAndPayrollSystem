<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "EmployeeDetails.Employee" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Employee Details</title>
<link rel="stylesheet" href="style.css">
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
	<h1>Employee Details</h1>
	<form class="home" action="Home" method="post">
		<input class="button" type="submit" value="Home">
	</form><br>
	<form class="logout" action="Logout" method="post">
		<input class="button" type="submit" value="Logout">
	</form>	<br><br>
	<form action="GetEmployeeDetailsServlet" method="get">
		<label for="EmployeeID">Employee ID:</label>
		<input type="number" name="employeeId" min="1000" required>
		<input class="submit" type="submit" onclick= "setValues()" value="GET">
		<br><br>
	</form>
	<form action = "SetEmployeeDetailsServlet" method="post">
		<input type="number" name="employeeId" min="1000" required value="${getEmployee.employeeId}" style="display:none;">
		<label>Employee Name:</label>
		<input type="text" name="employeeName" required value="${getEmployee.employeeName}" required>
		<br><br>
		<label>Date of Birth:</label>
	  	<input type="date" name="DOB" value="${getEmployee.DOB}" required/>
	  	<br><br>
		<label for="phone">Phone No:</label>
		<input type="tel" id="phone" name="phoneNo" placeholder="1234567890" pattern="[0-9]{10}" required value="${getEmployee.phoneNo}" required>
		<br/><br>
		<label>Email ID:</label>
		<input type="email" name="emailId" required value="${getEmployee.emailId}" required>
		<br><br>
		<label for="SalaryCTC">Salary per Annum	:</label>
	  	<input type="text" placeholder="Enter Salary per Annum" name="totalSalary" value="${getEmployee.totalSalary}"><br><br>		
		<label for="EmployeeRole">Select Employee Role	:</label>
	  	<select name="employeeRole" id="employeeRole" required>
	  		<option disabled selected value> -- select an option -- </option>
	  		<option value="Employee" <%
	  			Employee employee = (Employee) request.getAttribute("getEmployee");
	  			if(employee != null && employee.getEmployeeRole().equals("Employee")){
	  				out.println("selected");
	  			}
	  		%>>Employee</option>
	  		<option value="Admin" <%
	  			if(employee != null && employee.getEmployeeRole().equals("Admin")){
	  				out.println("selected");
	  			}
	  		%>>Admin</option>	
 		</select><br><br>
	  	<label for="EmployeeStatus">Select Employee Status	:</label>
	  	<select name="employeeStatus" id="employeeStatus" required>
	  		<option disabled selected value> -- select an option -- </option>
	  		<option value="active" <%
  				if(employee != null && employee.getEmployeeStatus().equals("active")){
	  				out.println("selected");
	  			}
	  		%>>Active</option>
	  		<option value="inactive" <%
  				if(employee != null && employee.getEmployeeStatus().equals("inactive")){
	  				out.println("selected");
	  			}	  		
	  		%>>Inactive</option>	
	  	</select><br><br>
		<input class="submit" type="submit" value="Update">		
	</form>
	<form action="RegisterEditEmployee.jsp" method="post">
		<input class="submit" type="submit" value="Reset">
	</form>
	<p id = "status" class="status">
	<%
	String status = (String) request.getAttribute("status");
	if(status != null) {
		if(status.equals("success")) {
			out.println("Updated Details!");
		}
		else if(status.equals("failed")) {
			out.println("Failed to fetch!");
		}
		else if(status.equals("notFound")) {
			out.println("Failed to fetch!");
		}
		else if(status.equals("inactive")) {
			out.println("No longer working with us!");
		}
		else if(status.equals("databaseConnectionFail")) {
			out.println("Connection to database Failed!");
		}
	}
	%>
	</p>
</body>
</html>