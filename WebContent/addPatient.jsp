<%@page session="true" %>
<%@page import="com.pbs.orm.*" %>
<%@page errorPage="errorPage.jsp" %>
<%@page import="com.pbs.utility.CurrentUser"%>
<%@page import="java.util.Iterator"%>

<h2>Add Patient</h2> 
<form id="addPatient" method="post" action="AddPatient">
	<label for="name" class="form_label">Name</label>
	<input id="name" name="name" type="text" value="" class="form_input"/><br>
	<label for="dob" class="form_label">Date of Birth(YY/MM/DD)</label>
	<input id="dob" name="dob" type="date" class="form_input" /><br>
	<label for="sex" class="form_label">Sex</label>
	<input name="sex" type="radio" value="M"/ checked="true">Male
	<input name="sex" type="radio" value="F"/>Female
	<input name="sex" type="radio" value="O"/>Other<br>
	<label for="address" class="form_label">Address</label>
	<textarea name="address" rows="3" cols="15" class="form_area"></textarea><br>
	<label for="email" class="form_label">Email</label>
	<input id="email" name="email" class="form_input" type="email"/><br>
	<label for="ward" class="form_label">Ward</label>
	<input name="ward" type="radio" value="GENERAL" checked="true"/>General
	<input name="ward" type="radio" value="EMERGENCY">Emergency
	<input name="ward" type="radio" value="ICU">ICU<br>
	<label for="doctor" class="form_label">Doctor Assigned(ID)</label>
	<input id="doctor" name="doctor" class="form_input" value=""/>
	<input type="button" value="Select" onclick="window.open('Doctors', 'docWindow', 'width=500px', height='500px')"><br>
	<label for="date_admit" class="form_label">Date Admit</label>
	<input id="date_admit" name="admitDate" type="date"/><br>
	<label for="status" class="form_label" >Status</label>
	<input name="status" type="radio" value="admit" checked="true"/>ADMIT
	<input name="status" type="radio" value="dispatch">DISPATCH<br>
	<label for="disease" class="form_label">Disease ID</label>
	<input name="disease" type="text" value="" class="form_input"/>
	<input type="button" value="Select" onclick="window.open('Diseases', 'diseaseWindow', 'width=500px', height='500px')"><br>
	<label for="contact" class="form_label">Contact No</label>
	<input id="contact" name="contact" type="text"  class="form_input"/><br>
	<label for="c_name" class="form_label">Contact Name</label>
	<input id="c_name" type="text" name="c_name" class="form_input"/><br>
    <label for="c_address" class="form_label">Contact Address</label>
	<input id="c_address" type="text" name="c_address" class="form_input"/><br>
	<label for="c_relation" class="form_label">Contact Relation</label>
	<input id="c_relation" type="text" name="c_relation" class="form_input"/><br>
	<input type="submit" value="add" class="">
</form>