<%@page session="true" %>
<%@page import="com.pbs.orm.*" %>
<%@page import="com.pbs.utility.CurrentUser"%>
<%@page errorPage="errorPage.jsp" %>

<%!
	Employee emp;
	CurrentUser cu;
%>
<% 
	emp = (Employee)request.getAttribute("emp");
	cu = (CurrentUser)session.getAttribute("current_user");
%>
<div id="profile">
	<table>
	<tbody>
	<tr> <th> Name </th> <td> <%= emp.getName()%></td> </tr>
	<tr> <th> Employee Id </th> <td> <%= emp.getId()%></td> </tr>
	<tr> <th> Department </th> <td> <a href="GetDepartment?id=<%=emp.getDepId()%>"><%= emp.getDepId()%></a></td> </tr>
	<tr> <th> Sex </th><td> <%= emp.getSex() %></td></tr>
	<tr> <th> Date Of Birth </th> <td> <%= emp.getDOB()%></td> </tr>
	<tr> <th> Designation </th> <td> <%= emp.getDesignation()%></td> </tr>
	<tr> <th> Qualifications </th> <td> <%= emp.getQualifications()%></td> </tr>	
	<tr> <th> Temporary Address </th> <td> <%= emp.getTemp()%></td> </tr>
	<tr> <th> Permanent Address </th> <td> <%= emp.getPermanent()%></td> </tr>
	<tr> <th> Contact No. </th><td> <%= emp.getContact()%></td> </tr>
	<tr> <th> Email </th><td> <%= emp.getEmail()%></td> </tr>
	<tr> <th> Salary </th><td> <%= emp.getSalary()%>&nbsp;Rs.</td></tr>
	</tbody>
	</table>
	<%if(emp.getId() == cu.emp.getId() || cu.role.equals("admin")) {%>
	<div class = "buttons">
		<a href="GetEmployee?id=<%=emp.getId() %>&action=edit">Edit</a>
	</div>
	<%} %>
</div>