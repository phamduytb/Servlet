
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
	<form action="http://localhost:8080/helloservlet/login" method="post">
		
		<div>
			<label>UserName:</label>
			<input type="text" name="username">
		</div>
		<div>
			<label>Password:</label>
			<input type="password" name="password">
		</div>
		<div>
			<button type="submit">Login</button>
		</div>
	</form>
</body>
</html>