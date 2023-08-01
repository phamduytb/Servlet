package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/user/*"})
public class AppFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Session (Là bộ nhớ ở phía server) - Lưu dữ liệu được vào session
		// session có 1 thời gian sống nhất định
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		System.out.println(session.getId());
		

		String uname = (String) session.getAttribute("username");
		
		if (uname!=null) {
			//Cho đi qua, nếu không gọi hàm dưới thì không cho đi qua
			chain.doFilter(request, response);
		} else {
			// Chuyển về trang login
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		
	}
}
