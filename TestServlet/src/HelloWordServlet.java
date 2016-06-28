import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWordServlet extends HttpServlet{
	//重写doGet方法
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("你调用了servlet方法！");
		resp.getWriter().write("<a href='http://www.baidu.com'>go</a>");
	}

}
