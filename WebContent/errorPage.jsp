<%@ page isErrorPage="true" import="java.io.*" %>
<html>
<head>
	<title>Exceptional Occurred!</title>
	<style>
	body, p { font-family:Tahoma; font-size:10pt; padding-left:30; }
	pre { font-size:8pt; }
	</style>
</head>
<body>

<%-- Exception Handler --%>
<font color="red">
<%= exception.toString() %><br>
</font>

<%
	out.println("<!--");
	StringWriter sw = new StringWriter();
	PrintWriter pw = new PrintWriter(sw);
	exception.printStackTrace(pw);
	out.print(pw);
	sw.close();
	pw.close();
	out.println("-->");
%>

</body>
</html>