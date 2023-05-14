<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Account</title>
</head>
<body>
<h2>account search</h2>

<form method="post" action="${pageContext.request.contextPath}/account/find.htm">
	Account No:<input type="text" name="accountNo" />
	<input type="submit" value="show">
</form>
</body>
</html>