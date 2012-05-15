<%@page session="true" %>
<%@page import="com.pbs.orm.*" %>
<%@page errorPage="errorPage.jsp" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.pbs.utility.CurrentUser"%>

<%!
	int count;
	List<Employee> list;
	Iterator<Employee> it;
	Employee emp;
	CurrentUser cu;
%>
<%
	list = (List)request.getAttribute("empList");
	cu = (CurrentUser)session.getAttribute("current_user");
	it = list.iterator();
	count = 1;
%>
<%if(cu.role.equals("admin")) {%>
	<div id="addEmp" class="buttons"><a href="pbsview.jsp?page=addEmployee">Add an Employee</a></div><br><br>
<%} %>
<div id="unit_list">	
	<table>
	<tbody>
		<tr><th>Sr.No</th><th>Name</th><th></th><th></th><th></th></tr>
		<% while(it.hasNext()){ 
			emp = it.next();
		%>
		<tr>
			<td><%= count++  %></td>
			<td><%= emp.getName() %></td>
			<td><div class="buttons"><a href="GetEmployee?id=<%=emp.getId()%>&action=view">View</a></div></td>
			<% if(cu.role.equals("admin") || emp.getId() == cu.emp.getId()) {%>
			<td><div class="buttons"><a  href="GetEmployee?id=<%=emp.getId() %>&action=edit">Edit</a></div></td>
				<% } %>
			<%if(cu.role.equals("admin")){%>
			<td><div class="buttons"><a href="#">Delete</a></div></td>
				<% } %>
			<% } %>
	  </tr>	
	</tbody>
	</table>
</div>