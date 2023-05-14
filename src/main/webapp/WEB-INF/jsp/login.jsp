<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Login Form</h2>
<form action="${pageContext.request.contextPath}/j_spring_security_login.htm" method="post">
	Email Adress: <input type="email" name="j_username"/><br/>
	Password : <input type="password" name="j_password"/> <br/>
	<input type="submit" value="Login"/>
</form>
</body>
</html>