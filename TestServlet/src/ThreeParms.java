import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����ͨ��doGet�Լ�doPost�õ������ķ���
public class ThreeParms extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("���ǲ���һ��"+req.getParameter("param1"));
		PrintWriter pw=resp.getWriter();
		pw.println("<br>");
		pw.println(req.getParameter("param1"));
		pw.println("<br>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("������dopost����Q!");
		doGet(req, resp);
	}
	
	
}
