import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

/**
 * 从客户端读取cookies
 * @author Admain
 *
 */
public class ShowCookies extends HttpServlet{
	/**
	 * 重写doget以及dopost方法
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies=req.getCookies();
		String c = null;
		for(int i=0;i<3;i++)
		{
			c=cookies[i].getValue();
		}
		for(int i=0;i<3;i++)
		{
			System.out.println("COOKIE是"+c);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}
	
}
