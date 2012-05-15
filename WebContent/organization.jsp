<%@page session="true" %>
<%@page import="com.pbs.orm.*" %>
<%@page errorPage="errorPage.jsp" %>
<%!
	Organization org;
%>
<%
	org = (Organization)session.getAttribute("org");
	session.removeAttribute("org");
%>
<div id="organization">
	<table>
	<tbody>
	<tr><th>Name</th><td><%= org.getName() %></td></tr>
	<tr><th>Organization ID</th><td><%= org.getId() %></td></tr>
	<tr><th>Address</th><td><%= org.getAddress() %></td></tr>
	<tr><th>Year Established</th><td><%= org.getYear() %></td></tr>
	</tbody>
	</table>
</div>