import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

/**
 * �ӿͻ��˶�ȡcookies
 * @author Admain
 *
 */
public class ShowCookies extends HttpServlet{
	/**
	 * ��дdoget�Լ�dopost����
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
			System.out.println("COOKIE��"+c);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}
	
}
