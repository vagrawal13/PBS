
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.pbs.orm.*" %>
<%@page import="com.pbs.utility.CurrentUser"%>
<%@page errorPage="errorPage.jsp" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/pbs.css">
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<%!
	List<Employee> doctors;
	Iterator it;
	Employee doc;
%>
<%
	doctors = (List)request.getAttribute("docList");
    it = doctors.iterator();
%>
<h2>Select a doctor</h2>
<ol class="list">
	<%while(it.hasNext()){ 
		doc = (Employee)it.next();	
	%>
		<li id="<%= doc.getId() %>"><%=doc.getName()%></li>
	<%} %>
</ol>
<input type="button" name="done" value="Done" onclick="onWindowSubmit('doctor')"/>
<input type="button" name="cancel" value="Cancel"/>
</body>
</html>