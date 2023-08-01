package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User;
import service.UserService;

@WebServlet("/user/edit")
public class UserEditController extends HttpServlet{
	UserService userService = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		User user = userService.getUserById(Integer.parseInt(id));
		req.setAttribute("user", user);
		req.getRequestDispatcher("/views/edit-user.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// Lấy dữ liệu gửi lên từ form
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// Gọi service để sửa user
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setAge(Integer.parseInt(age));
		user.setUsername(username);
		user.setPassword(password);
		userService.update(user);
				
		// Chuyển về trang danh sách User sau khi thêm thành công
		// Chuyển ở phía trình duyệt.
		resp.sendRedirect(req.getContextPath() + "/user/list");
	}
}
