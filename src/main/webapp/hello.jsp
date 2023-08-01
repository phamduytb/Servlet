<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h1>Hello JSP</h1>
	<%
		String s= request.getRemoteAddr();
		int x = 20;
	%>
	<h1><%=s %></h1>
	<h1><%=x %></h1>
</body>
</html>