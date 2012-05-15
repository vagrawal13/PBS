<%@page session="true" %>
<%@page import="com.pbs.orm.*" %>
<%@page errorPage="errorPage.jsp" %>

<%!
	Department dep;
	Organization org;
%>
<%
	dep = (Department)request.getAttribute("department");
	org = (Organization)request.getAttribute("org");
	session.setAttribute("org",org);
%>
<div id="department">
	<h2>Welcome to the <%= dep.getName() %> Department</h2>
	<table>
	<tbody>
	<tr><th>Name</th><td><%= dep.getName() %></td></tr>
	<tr><th>Department ID</th><td><%= dep.getId() %></td></tr>
	<tr><th>Parent Organization</th><td><a href="pbsview.jsp?page=organization"><%= org.getName() %></a></td></tr>
	<tr><th>Extension No</th><td><%= dep.getExtension() %></td></tr>
	<tr><th>General Bed (total)</th><td><%= dep.getGenBed() %></td></tr>
	<tr><th>General Available</th><td><%= dep.getGenAvail() %></td></tr>
	<tr><th>Emergency Bed (total)</th><td><%= dep.getEmgBed() %></td></tr>
	<tr><th>Emergency Available</th><td><%= dep.getEmgAvail() %></td></tr>
	<tr><th>ICU Bed (total)</th><td><%= dep.getIcuBed() %></td></tr>
	<tr><th>ICU Available</th><td><%= dep.getIcuAvail() %></td></tr>
	</tbody>
	</table>
</div>