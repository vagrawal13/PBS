<%@page session="true" %>
<%@page import="com.pbs.orm.*" %>
<%@page errorPage="errorPage.jsp" %>
<%@page import="com.pbs.utility.CurrentUser"%>
<%@page import="java.util.Iterator"%>

<%!
	Employee emp;
	Department dep;
	CurrentUser cu;
	Iterator it;
	boolean isMChecked,isFChecked,isOChecked;
%>
<% 
	emp = (Employee)request.getAttribute("emp");
	cu = (CurrentUser)session.getAttribute("current_user");
	it = cu.departments.iterator();
	isMChecked = false;
	isFChecked = false;
	isOChecked = false;
%>

<h2>Edit Employee Profile</h2> 
<form method="post" id="editemp" action="EditEmployee?id=<%=emp.getId()%>">
	<label for="name" class="form_label">Name</label>
	<input id="name" name="name" type="text" value="<%=emp.getName() %>" size="20" class="form_input" /><br>
	<% if(cu.role.equals("admin")) {%>
		<label for="dep" class="form_label">Department</label>
		<select name="department" class="form_input">
		<%while(it.hasNext()) {
			dep = (Department)it.next();
		%>
			<option value=<%= dep.getId() %>><%=dep.getName()%></option>
		<%} %>	
		</select><br>
		<label for="desig" class="form_label">Designation</label>
		<input id="desig" name="designation" type="text" value="<%= emp.getDesignation() %>" size="20" class="form_input"/><br>
		<label for="salary" class="form_label">Salary</label>
		<input id="salary" name="salary" type="text" value="<%= emp.getSalary() %>" size="20" class="form_input"/><br>
	<% } %>
	<%if(emp.getSex().equals("M")) isMChecked = true;
	  if(emp.getSex().equals("F")) isFChecked = true;
	  if(emp.getSex().equals("O")) isOChecked = true;
	%>
	<label for="sex" class="form_label" >Sex</label>
	<input name="sex" type="radio" value="M" checked="<%=isMChecked %>" />Male
	<input name="sex" type="radio" value="F" checked="<%=isFChecked %>"/>Female
	<input name="sex" type="radio" value="O" checked="<%=isOChecked %>"/>Other<br>
	<label for="dob" class="form_label">Date of Birth(YY/MM/DD)</label>
	<input id="dob" name="dob" type="date" class="form_input" value="<%=emp.getDOB() %>"/><br>
	<label for="qual" class="form_label">Qualifications</label>
	<textarea name="qualification" rows="3" cols="15" class="form_area"><%= emp.getQualifications() %></textarea><br>
	<label for="temp" class="form_label">Temporary Address</label>
	<textarea name="temporary" rows="3" cols="15" class="form_area"><%= emp.getTemp() %></textarea><br>
	<label for="perm" class="form_label">Permanent Address</label>
	<textarea id="perm" name="permanent" rows="3" cols="15" class="form_area" ><%= emp.getPermanent() %></textarea><br>
	<label for="contact" class="form_label">Contact No</label>
	<input id="contact" name="contact" type="text" value="<%= emp.getContact() %>" class="form_input" /><br>
	<label for="email" class="form_label">Email</label>
	<input id="email" name="email" value="<%= emp.getEmail() %>"type="email" class="form_input"/><br>
	<input type="submit" value="Save" class="form_submit"/><br>
</form>