import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试cookie以及其用法
 * @author Admain
 *
 */
public class setCookie extends HttpServlet{
	//用doget方法进行访问
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		for(int i=0;i<3;i++)
		{
			Cookie cookie=new Cookie("Session-Cookie"+i, "Cookie-Value-s"+i);
			resp.addCookie(cookie);
			cookie=new Cookie("Persistent-Cookie"+i, "Cookie-value-p"+i);
			cookie.setMaxAge(3600);
			resp.addCookie(cookie);
		}
		//设置返回文本的数据类型
		resp.setContentType("text/html;chatset=gb2312");
		PrintWriter out=resp.getWriter();
		String title="Settign Cookies";
		out.println("<html><head><title>设置cookie</title></head>"
					+"<BODY BGCOLOR=\"#FDF5E6\"\n"+"H1 Align=\"CENTER\">"
					+title+"</H1>\n"
					+"There is six cookie associated with this page.\n"
					+"To see them,visit the\n"
					+"herf=");
		//注意后边少一个showCookie方法
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
