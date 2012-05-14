<%@page session="true" %>
<%@page import="com.pbs.utility.CurrentUser" %>
<%@page errorPage="errorPage.jsp" %>

<%! 
	CurrentUser cu;
%>
<div id="homepage">
		<%cu = (CurrentUser)session.getAttribute("current_user"); %>
		Welcome : <b><%= cu.emp.getName() %></b>
</div>
