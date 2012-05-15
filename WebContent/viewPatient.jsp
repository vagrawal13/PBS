<%@page session="true" %>
<%@page import="com.pbs.orm.*" %>
<%@page import="com.pbs.utility.CurrentUser"%>
<%@page errorPage="errorPage.jsp" %>

<%!
	Patient patient;
	CurrentUser cu;
%>
<% 
	patient = (Patient)request.getAttribute("patient");
	cu = (CurrentUser)session.getAttribute("current_user");
%>
<div id="profile">
	<table>
	<tbody>
	<tr> <th> Name </th> <td> <%= patient.getName()%></td> </tr>
	<tr> <th> Patient Id </th> <td> <%= patient.getId()%></td> </tr>
	<tr> <th> Date Of Birth </th> <td> <%= patient.getDob()%></td> </tr>
	<tr> <th> Sex </th> <td> <%= patient.getSex()%></td> </tr>
	<tr> <th> Address </th> <td> <%= patient.getAddress()%></td> </tr>
	<tr> <th> Email </th> <td> <%= patient.getEmail()%></td> </tr>	
	<tr> <th> Ward </th> <td> <%= patient.getWard()%></td> </tr>
	<tr> <th> Doctor Assigned(Id) </th> <td> <%=patient.getDocId()%></td> </tr>
	<tr> <th> Date Admit</th><td> <%= patient.getDateAdmit()%></td> </tr>
	<tr> <th> Staus </th><td> <%= patient.getStatus()%></td> </tr>
	<tr> <th> Diasease Id</th><td> <%= patient.getDisease()%></td></tr>
	<tr> <th> Contact No.</th><td> <%=patient.getContact() %></td>
	<tr> <th> Contact Name </th><td> <%= patient.getContactName()%></td></tr>
	<tr> <th> Contact Address </th><td> <%= patient.getContactAdd()%></td></tr>
	<tr> <th> Contact Relation </th><td> <%= patient.getContactRel()%></td></tr>
	</tbody>
	</table>
	<%if(cu.role.equals("admin") || cu.role.equals("receptionist")) {%>
	<div class = "buttons">
		<a href="GetPatient?id=<%= patient.getId() %>&action=edit">Edit</a>
	</div>
	<%} %>
</div>