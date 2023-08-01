package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User;
import service.UserService;

@WebServlet("/user/list")
public class UserListController extends HttpServlet{
	UserService userService = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = userService.getUsers();
		
		req.setAttribute("userList", users);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/list-user.jsp");
		
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		List<User> users = userService.getUsersByNameOrUsername(keyword);
		req.setAttribute("userList", users);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/list-user.jsp");
		
		dispatcher.forward(req, resp);
	}
}
