<%@page session="true" %>
<%@page import="com.pbs.orm.*" %>

<%
	CurrentUser cu = (CurrentUser)session.getAttribute("current_user");
%>
	
<%@page import="com.pbs.utility.CurrentUser"%><ul id="nav">
	   <li><a href="pbsview.jsp?page=home" class="m1">Home Page</a></li>
	   <li><a href="pbsview.jsp?page=profile" class="m2">My Profile</a></li>
	   <li><a href="#" class="m3">Encyclopedia</a></li>
	   <li><a href="#" class="m4">Contact Us</a></li>
	   <li><a href="Logout">Logout</a></li>
	</ul>
	
