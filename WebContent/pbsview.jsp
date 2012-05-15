<%@ taglib uri="/WEB-INF/tags/template.tld" prefix="template" %>
<%@page session="true" %>
<%!
	String str = "";
	CurrentUser cu;
%>
<%  
	str = request.getParameter("page") + ".jsp";
	cu = (CurrentUser)session.getAttribute("current_user");
%>


<%@page import="com.pbs.utility.CurrentUser"%><template:insert template="/myTemplate.jsp">
	<template:put name="title" content="Patient Billing Software" direct="true" />
	<template:put name="header" content="header.jsp"/>
	<%if(cu.role.equals("admin")){ %>
	<template:put name="sidebar" content="sidebar_a.jsp"/>
	<%} %>
	<%if(cu.role.equals("receptionist")){ %>
	<template:put name="sidebar" content="sidebar_r.jsp"/>
	<%} %>
	<template:put name="rightbar" content="<%= str %>"/>
</template:insert>