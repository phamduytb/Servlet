package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//loadOnStartup = 1 khởi tạo servlet ngay khi start serve
// Bình thường thì phải có request đến đường dẫn thì mới khởi tạo servlet
@WebServlet(urlPatterns = "/hi", loadOnStartup = 1)
public class HiController extends HttpServlet{
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("INIT");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("DESTROY");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//request
		System.out.println(req.getRemoteAddr());
		
		//response
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("Hi");
		pw.println("<h1>Hi HTML</h1>");
	}
}
