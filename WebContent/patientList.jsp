<%@page session="true" %>
<%@page import="com.pbs.orm.*" %>
<%@page errorPage="errorPage.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.pbs.utility.CurrentUser"%>

<%!
	int count;
	List<Patient> list;
	Iterator<Patient> it;
	Patient patient;
	CurrentUser cu;
%>
<%
	list = (List)request.getAttribute("patientList");
	cu = (CurrentUser)session.getAttribute("current_user");
	it = list.iterator();
	count = 1;
%>
<%if(cu.role.equals("admin") || cu.role.equals("receptionist")) {%>
	<div id="addPat" class="buttons"><a href="pbsview.jsp?page=addPatient">Add a Patient</a></div><br><br>
<%} %>
<div id="pat_list">	
	<table>
	<tbody>
		<tr><th>Sr.No</th><th>Name</th><th>Registration No</th><th></th><th></th><th></th></tr>
		<% while(it.hasNext()){ 
			patient = it.next();
		%>
		<tr>
			<td><%= count++  %></td>
			<td><%= patient.getName() %></td>
			<td><%= patient.getRegNo() %></</td>
			<td><div class="buttons"><a href="GetPatient?id=<%=patient.getId()%>&action=view">View</a></div></td>
			<% if(cu.role.equals("admin") || cu.role.equals("receptionist") || patient.getId() == cu.emp.getId()) {%>
			<td><div class="buttons"><a  href="GetPatient?id=<%=patient.getId() %>&action=edit">Edit</a></div></td>
				<% } %>
			<%if(cu.role.equals("admin") || cu.role.equals("receptionist")){%>
			<td><div class="buttons"><a href="#">Delete</a></div></td>
				<% } %>
			<% } %>
	  </tr>	
	</tbody>
	</table>
</div>