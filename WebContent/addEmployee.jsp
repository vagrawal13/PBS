<%@page session="true" %>
<%@page import="com.pbs.orm.*" %>
<%@page errorPage="errorPage.jsp" %>
<%@page import="com.pbs.utility.CurrentUser"%>
<%@page import="java.util.Iterator"%>

<%!
	Employee emp;
	CurrentUser cu;
	Department dep;
	Iterator it;
%>
<% 
	emp = (Employee)request.getAttribute("emp");
	cu = (CurrentUser)session.getAttribute("current_user");
	it = cu.departments.iterator();
%>

<h2>Add Employee</h2> 
<form method="post" id="addemp" action="AddEmployee">
	<label for="name" class="form_label">Name</label>
	<input id="name" name="name" type="text" value="" class="form_input" /><br>
	<label for="pass" class="form_label">Password</label>
	<input id="pass" name="password" type="password" value="" class="form_input" /><br>
	<label for="dep" class="form_label">Department</label>
	<select name="department" class="form_input">
		<%while(it.hasNext()) {
			dep = (Department)it.next();
		%>
			<option value=<%= dep.getId() %>><%=dep.getName()%></option>
		<%} %>	
		</select><br>
	<label for="sex" class="form_label">Sex</label>
	<input name="sex" type="radio" value="M" checked="true"/>Male
	<input name="sex" type="radio" value="F"/>Female
	<input name="sex" type="radio" value="O"/>Other<br>
	<label for="desig" class="form_label">Designation</label>
	<input id="desig" name="designation" type="text" value="" size="20" class="form_input"/><br>
	<label for="salary" class="form_label">Salary</label>
	<input id="salary" name="salary" type="text" value="" size="20" class="form_input"/><br>
	<label for="dob" class="form_label">Date of Birth(YY/MM/DD)</label>
	<input id="dob" name="dob" type="date" class="form_input" /><br>
	<label for="qual" class="form_label">Qualifications</label>
	<textarea name="qualification" rows="3" cols="15" class="form_area"></textarea><br>
	<label for="temp" class="form_label">Temporary Address</label>
	<textarea name="temporary" rows="3" cols="15" class="form_area"></textarea><br>
	<label for="perm" class="form_label">Permanent Address</label>
	<textarea name="permanent" rows="3" cols="15" class="form_area" ></textarea><br>
	<label for="contact" class="form_label">Contact No</label>
	<input id="contact" name="contact" type="text" value="" class="form_input" /><br>
	<label for="email" class="form_label">Email</label>
	<input id="email" name="email" value="" type="email" class="form_input"/><br>
	<input type="submit" value="Save" class="form_submit"/><br>
</form>