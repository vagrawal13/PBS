<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Billing System</title>
<link rel="stylesheet" type="text/css" href="css/pbs.css">
</head>
<body>
<div id="container">
	<div id="login">
		<h1>Login</h1>
		Please enter your username and password
		<form action="CheckLogin" method="POST">
		<label for="empId">Employee ID: </label><input type="text" name="empId" length="40"></p>
		<label for="password">Password: <input type="password" name="password" length="40"></p>
		<input type="submit" value="Submit">
		</form>
	</div>	
</div>
</body>
</html>