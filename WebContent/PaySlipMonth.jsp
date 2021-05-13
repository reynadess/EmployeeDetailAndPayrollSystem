<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "salaryStructure.Salary" %>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<style type="text/css"> 
.salary-slip{
      margin: 15px;
      }
      .empDetail {
        width: 100%;
        text-align: left;
        border: 2px solid black;
        border-collapse: collapse;
        table-layout: auto;
      }
      .myBackground {
        padding-top: 10px;
        text-align: left;
        border: 1px solid black;
        height: 40px;
      }
      
      .head {
        margin: 10px;
        margin-bottom: 50px;
        width: 100%;
      }
      
      .companyName {
        text-align: right;
        font-size: 25px;
        font-weight: bold;
      }
      
      .salaryMonth {
        text-align: center;
      }
      
      .table-border-bottom {
        border-bottom: 1px solid;
      }
      
      .table-border-right {
        border-right: 1px solid;
      }
      
      .myAlign {
        text-align: center;
        border-right: 1px solid black;
      }
      
      .myTotalBackground {
        padding-top: 10px;
        text-align: left;
        background-color: #EBF1DE;
        border-spacing: 0px;
      }
      
      .align-4 {
        width: 25%;
        float: left;
      }
      
      .tail {
        margin-top: 35px;
      }
      
      .align-2 {
        margin-top: 25px;
        width: 50%;
        float: left;
      }
      
      .border-center {
        text-align: center;
      }
      .border-center th, .border-center td {
        border: 1px solid black;
      }
      
      th, td {
        padding-left: 6px;
      }
</style>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Pay Slip Employee</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if(session.getAttribute("employeeDetail") == null ){ 
	response.sendRedirect("index.jsp");
}
%>
<h1>Pay Slip</h1>
<form class="home" action="Home" method="post">
	<input class="button" type="submit" value="Home">
</form>
<form class="logout" action="Logout" method="post">
	<input class="button" type="submit" value="Logout">
</form>

<form action="GetPaySlipServlet" method="post">
	<label for="Month">Select the month to view pay slip	:</label>
	<input type="month" name="salaryMonth"><br><br>
	<input class="submit" type="submit" value="GET">
</form>
<br/> <br/>
<label style="text-align: left">Pay Slip of ${salary.month}</label>

<div class="salary-slip" style="background-color: White">
	<table class="empDetail">
		<tr>
			<th colspan="2">
				Employee ID:
			</th>
            <td>
            	${employeeDetail.employeeId}
            </td>
            <td colspan="5"></td>
		</tr>
		<tr>
			<th colspan="2">
				Name:
      		</th>
      		<td>
      			${employeeDetail.employeeName}
      		</td>
      		<td colspan="5"></td>
      	</tr>
		<tr>
			<th colspan="2">
				Pay Slip Id:
			</th>
			<td>
				${salary.paySlipId}
			</td>
			<td colspan="5"></td>
		</tr>
		<tr class="myBackground">
			<th colspan="3">
				Payments Particular
			</th>
			<th class="table-border-right">
				Amount (Rs.)
			</th>
			<th colspan="3">
				Deductions Particular
			</th>
			<th >
				Amount (Rs.)
			</th>
		</tr>
		<tr>
			<th colspan="3">
				Basic Salary
			</th>
			<td class="myAlign">
				${salary.netBaseSalary}
			</td>
			<th colspan="3" >
				Others
			</th >
			<td class="myAlign">
				${salary.otherAllowance}
      		</td>
      	</tr >
      	<tr>
      		<th colspan="3">
      			Dearness Allowance
      		</th>
      		<td class="myAlign">
      			${salary.dearnessAllowance}
			</td>
			<th colspan="3">
				Employee Provident Fund
			</th>
			<td  class="myAlign">
				${salary.employeeProvidientFund}
			</td>
		</tr >
		<tr>
			<th colspan="3">
				Traveling Allowance
			</th>
			<td class="myAlign">
				${salary.travellingAllowance}
      		</td>
      		<th colspan="4"></th>
      	</tr>
      	<tr>
      		<th colspan="3" >
      			House Rent Allowance
      		</th>
      		<td class="myAlign">
      			${salary.housingRentAllowance}
      		</td>
      		<th colspan="4"></th>
      	</tr >
      	<tr class="myBackground">
      		<th colspan="3">
      			Total Payments
      		</th>
      		<td class="myAlign">
      			<%
      				Salary salary = (Salary) request.getAttribute("salary");
	      			if(salary != null){
	      				int total = salary.getNetBaseSalary() + salary.getDearnessAllowance() + salary.getTravellingAllowance() + salary.getHousingRentAllowance();
	      				out.println(total);
	      			}else{
	      				out.println(0);
	      			}
      			%>
      		</td>
      		<th colspan="3" >
      			Total Deductions
      		</th >
      		<td class="myAlign">
      			<%	
      				if(salary != null) {
	  					int totalDeductions = salary.getOtherAllowance() + salary.getEmployeeProvidientFund();
	  					out.println(totalDeductions);
      				}
      				else{
      					out.println(0);
      				}
  				%>
      		</td>
      	</tr>
	</table >
</div >
<br><label >Gross Salary	:	${salary.finalGrossSalary}</label><br><br>
<label >Loss Of Pay		:	${salary.lossOfPay}</label><br><br>
<label>Net Salary Credited	:	${salary.finalNetSalary}</label>
</body>
</html>