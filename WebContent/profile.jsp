<%@page session="true" %>
<%@page import="com.pbs.orm.*" %>
<%@page import="com.pbs.utility.CurrentUser"%>
<%@page errorPage="errorPage.jsp" %>

<%!
	CurrentUser cu;
%>
<% 
	cu = (CurrentUser)session.getAttribute("current_user");
%>
<div id="profile">
	<table>
	<tbody>
	<tr> <th> Name </th> <td> <%= cu.emp.getName()%></td> </tr>
	<tr> <th> Employee Id </th> <td> <%= cu.emp.getId()%></td> </tr>
	<tr> <th> Department </th> <td> <a href="GetDepartment?id=<%=cu.dep.getId()%>"><%= cu.dep.getName()%></a></td> </tr>	
	<tr> <th> Date Of Birth </th> <td> <%= cu.emp.getDOB()%></td> </tr>
	<tr> <th> Designation </th> <td> <%= cu.emp.getDesignation()%></td> </tr>
	<tr> <th> Qualifications </th> <td> <%= cu.emp.getQualifications()%></td> </tr>	
	<tr> <th> Temporary Address </th> <td> <%= cu.emp.getTemp()%></td> </tr>
	<tr> <th> Permanent Address </th> <td> <%= cu.emp.getPermanent()%></td> </tr>
	<tr> <th> Contact No. </th><td> <%= cu.emp.getContact()%></td> </tr>
	<tr> <th> Email </th><td> <%= cu.emp.getEmail()%></td> </tr>
	<tr> <th> Salary </th><td> <%= cu.emp.getSalary()%>&nbsp;Rs.</td> </tr>
	</tbody>
	</table>
	<div class = "buttons"><a href="GetEmployee?id=<%=cu.emp.getId() %>&action=edit">Edit</a></div>
	
</div>