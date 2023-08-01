<%@page import="java.util.List"%>
<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User</title>
</head>
<body>
	<button><a href="http://localhost:8080/helloservlet/user/new">Create User</a></button>
	<% List<User> users = (List<User>)request.getAttribute("userList"); %>
	<table border="1">
		<thead>
			<th>Id</th>
		    <th>Name</th>
		    <th>Age</th>
		    <th>Edit</th>
		    <th>Delete</th>
		</thead>
		  <tbody>
		  	 <% for (User user : users) { %>
		  	 <tr>
		  	 	<td><%=user.getId() %></td>
		  	 	<td><%=user.getName() %></td>
		  	 	<td><%=user.getAge() %></td>
		  	 	<td><a href="http://localhost:8080/helloservlet/user/edit?id=<%=user.getId() %>">Edit</a></td>
		  	 	<td><a href="http://localhost:8080/helloservlet/user/delete?id=<%=user.getId() %>">Delete</a></td>
		  	 </tr>
		  	 <% } %>
		  </tbody>
	</table>
	<form action="http://localhost:8080/helloservlet/user/list" method="post">
		<input placeholder="Nhập tên hoặc username" name="keyword">
		<button type="submit">Search</button>
	</form>
</body>
</html>