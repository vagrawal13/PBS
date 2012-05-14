<%@taglib uri="/WEB-INF/tags/template.tld" prefix="template" %> 
<%@page session="true"%>
<%@page import="com.pbs.orm.*" %>
<%@page import="com.j256.ormlite.support.ConnectionSource" %>
<%@page import="com.j256.ormlite.jdbc.JdbcConnectionSource" %>  
<%@page import="com.j256.ormlite.dao.DaoManager" %> 
<%@page import="com.j256.ormlite.dao.Dao" %>
<%@page errorPage="errorPage.jsp" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="A patient billing software.">
<meta name="author" content="[V]!CT0R__--->>">
<link rel="stylesheet" type="text/css" href="css/pbs.css">
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<title><template:get name="title" /></title>
</head>
<body>
<%!
	String temp="";
	Long emp_id ;
	Employee emp;

%>
<%	
	emp = (Employee)session.getAttribute("emp");
%>
<div class="container">
	<header>
		<template:get name="header" />
	</header>
	<div id="wrapper">
		<aside>
			<template:get name="sidebar"/>
		</aside>	
		<div class="sub-container"><template:get name="rightbar"/></div>
	</div>
</div>
	
  <%-- Footer --%>
   <jsp:include page="footer.jsp"/>
   
</body>
</html>