<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User</title>
</head>
<body>
	<form action="http://localhost:8080/helloservlet/user/new" method="post">
		
		<div>
			<label>Name:</label>
			<input type="text" name="name">
		</div>
		<div>
			<label>Age:</label>
			<input type="text" name="age">
		</div>
		<div>
			<label>UserName:</label>
			<input type="text" name="username">
		</div>
		<div>
			<label>Password:</label>
			<input type="password" name="password">
		</div>
		<div>
			<button type="submit">Submit</button>
		</div>
	</form>
</body>
</html>