<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accont Information</title>
</head>
<body>

	<h2>Accoutn Information</h2>

	<p>Account no:${account.accountNo}</p>
	<p>Account Holder Name:${account.accountHodlerName}</p>
	<p>Account Type:${account.accountType}</p>
	<p>Balance :${account.balance}</p>
	<p>IIFC Code:${account.ifscCode}</p>
	<p>Balance:${account.balance}</p>

	<%-- <security:authorize access="hasAny('clerk','manager')">
		<p>Status :${account.status}</p>
	</security:authorize> --%>
</body>
</html>