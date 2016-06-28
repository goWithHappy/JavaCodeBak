import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 测试session
 * @author Admain
 *
 */
public class SessionInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到当前session，如果没有session就创建一个
		HttpSession mySession=request.getSession(true);
		//设计
		response.setContentType("text/html");
		//得到一个输出流
		PrintWriter out=response.getWriter();
		//写入到客户端的正常文件
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<Title>Session INFo Servlet</Title>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<H3>Session Information</H3>");
		out.println("NewSession ID:"+mySession.isNew());
		out.println("<BR>Session ID:"+mySession.getId());
		//得到创建Session的时间
		out.println("<BR>Session Creation Time:"
				+new java.util.Date(mySession.getCreationTime()));
		//得到最后连接时间
		out.println("<BR>Session Last Accessed Time:"
				+new java.util.Date(mySession.getLastAccessedTime()));
		out.println("<H3>Request Information</H3>");
		out.println("SessionId from Request:"
				+request.getRequestedSessionId());
		//测试cookie是否是保存在cookie里边
		out.println("<BR>Sesssion ID via Cookie:"
				+request.isRequestedSessionIdFromCookie());
		//测试是否是重写了url方法
		out.println("<BR>Session ID via rewritten :"
		+request.isRequestedSessionIdFromURL());
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
