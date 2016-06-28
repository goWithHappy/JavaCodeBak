import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 显示系统中读入的session
 * @author Admain
 *
 */

public class ShowSession extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置返回给客户端的文本类型
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String title="sesson Tracking Example";
		//获得客户端的session
		HttpSession session=request.getSession(true);
		String heading = null;
		//使用session的getAttribute方法的到客户端返回的参数(Integer相当于int类型)
		Integer accessCount=(Integer)session.getAttribute("accessCount");
		//判断session内的参数是否为空，如果为空则向里边写入键值对
		if (accessCount==null) {
			accessCount=new Integer(0);
		}
		else
		{
			heading="Welcome Back";
			accessCount=new Integer(accessCount.intValue()+1);
		}
		//设置session的参数
		session.setAttribute("accessCount", accessCount);
		//打印返回给客户端的数据
		out.println("<html><head><title>Session追踪测试</title></head>"
				   +"<Body BGCOLOR=\"#FDF5E6\">"+"<H1 Align=\"CENTER\">"
				   +heading+"</H1>\n"
				   +"<H2>Information on your seeion:</H2>\n"
				   +"<Table Border=1 align=\"center\">\n"
				   +"<TR>Info Type<TE>Value\n"
				   +"<TR>\n"+"<TD>ID\n"+"TD"+session.getId()+"\n"
				   +"<TR>\n"+"<TD>ip Address\n"+"<TD>"+request.getRemoteAddr()+"\n"
				   +"<TR>\n"+"<TD>Creation Time\n"+"<TD>"
				   +new Date(session.getCreationTime())+"\n"+"<TR>\n"
				   +new Date(session.getLastAccessedTime())+"\n"+"<TR>\n"
				   +"<TD>Number of Previous Accesses\n"+"TD"
				   +accessCount+"\n"+"</Table>\n"+"</BODY></HTML>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
