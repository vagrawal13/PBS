<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.pbs.orm.*" %>
<%@page errorPage="errorPage.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/pbs.css">
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Disease</title>
</head>
<body>
<%!
	List<Disease> diseaseList;
	Disease disease;
	Iterator it;
%>
<%
	diseaseList = (List)request.getAttribute("diseaseList");
	it = diseaseList.iterator();
%>
<ol class="list">
	<%while(it.hasNext()){ 
		disease = (Disease)it.next();	
	%>
		<li id="<%= disease.getId() %>"><%=disease.getName()%></li>
	<%} %>
</ol>
<input type="button" name="done" value="Done" onclick="onWindowSubmit('disease')"/>
<input type="button" name="cancel" value="Cancel"/>
</body>
</html>