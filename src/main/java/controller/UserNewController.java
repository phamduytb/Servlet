package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User;
import service.UserService;

@WebServlet("/user/new")
public class UserNewController extends HttpServlet{
	UserService userService = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Gọi đến trang có form để thêm user
		// Chuyển req, resp từ servlet hiện tại sang servlet khác.
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/new-user.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		// Lấy dữ liệu gửi lên từ form
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// Gọi service để thêm user
		User user = new User();
		user.setName(name);
		user.setAge(Integer.parseInt(age));
		user.setUsername(username);
		user.setPassword(password);
		userService.create(user);
		
		// Chuyển về trang danh sách User sau khi thêm thành công
		// Chuyển ở phía trình duyệt.
		resp.sendRedirect(req.getContextPath() + "/user/list");
	}
}
