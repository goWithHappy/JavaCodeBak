import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ��ʾϵͳ�ж����session
 * @author Admain
 *
 */

public class ShowSession extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���÷��ظ��ͻ��˵��ı�����
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String title="sesson Tracking Example";
		//��ÿͻ��˵�session
		HttpSession session=request.getSession(true);
		String heading = null;
		//ʹ��session��getAttribute�����ĵ��ͻ��˷��صĲ���(Integer�൱��int����)
		Integer accessCount=(Integer)session.getAttribute("accessCount");
		//�ж�session�ڵĲ����Ƿ�Ϊ�գ����Ϊ���������д���ֵ��
		if (accessCount==null) {
			accessCount=new Integer(0);
		}
		else
		{
			heading="Welcome Back";
			accessCount=new Integer(accessCount.intValue()+1);
		}
		//����session�Ĳ���
		session.setAttribute("accessCount", accessCount);
		//��ӡ���ظ��ͻ��˵�����
		out.println("<html><head><title>Session׷�ٲ���</title></head>"
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
