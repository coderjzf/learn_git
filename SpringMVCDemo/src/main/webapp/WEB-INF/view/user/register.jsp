<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Register</title>
</head>
<body>
	<form action="<c:url value="/user.html" />" method="post">
		<table>
			<tr><td>username:</td><td><input type="text" name="username"></td></tr>
			<tr><td>password:</td><td><input type="text" name="password"></td></tr>
			<tr><td colspan="2"><input type="submit" value="submit"></td></tr>
		</table>
	</form>
</body>
</html>