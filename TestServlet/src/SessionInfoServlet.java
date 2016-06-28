import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ����session
 * @author Admain
 *
 */
public class SessionInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�õ���ǰsession�����û��session�ʹ���һ��
		HttpSession mySession=request.getSession(true);
		//���
		response.setContentType("text/html");
		//�õ�һ�������
		PrintWriter out=response.getWriter();
		//д�뵽�ͻ��˵������ļ�
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<Title>Session INFo Servlet</Title>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<H3>Session Information</H3>");
		out.println("NewSession ID:"+mySession.isNew());
		out.println("<BR>Session ID:"+mySession.getId());
		//�õ�����Session��ʱ��
		out.println("<BR>Session Creation Time:"
				+new java.util.Date(mySession.getCreationTime()));
		//�õ��������ʱ��
		out.println("<BR>Session Last Accessed Time:"
				+new java.util.Date(mySession.getLastAccessedTime()));
		out.println("<H3>Request Information</H3>");
		out.println("SessionId from Request:"
				+request.getRequestedSessionId());
		//����cookie�Ƿ��Ǳ�����cookie���
		out.println("<BR>Sesssion ID via Cookie:"
				+request.isRequestedSessionIdFromCookie());
		//�����Ƿ�����д��url����
		out.println("<BR>Session ID via rewritten :"
		+request.isRequestedSessionIdFromURL());
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
