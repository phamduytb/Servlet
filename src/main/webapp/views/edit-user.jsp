<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
</head>
<body>
	<% User user = (User)request.getAttribute("user"); %>
	<form action="http://localhost:8080/helloservlet/user/edit" method="post">
		<div>
			<label>Id:</label>
			<input type="text" name="id" readonly="readonly" value="<%=user.getId()%>">
		</div>
		<div>
			<label>Name:</label>
			<input type="text" name="name" value="<%=user.getName()%>">
		</div>
		<div>
			<label>Age:</label>
			<input type="text" name="age" value="<%=user.getAge()%>">
		</div>
		<div>
			<label>UserName:</label>
			<input type="text" name="username" value="<%=user.getUsername()%>">
		</div>
		<div>
			<label>Password:</label>
			<input type="password" name="password" value="<%=user.getPassword()%>">
		</div>
		<div>
			<button type="submit">Submit</button>
		</div>
	</form>
</body>
</html>