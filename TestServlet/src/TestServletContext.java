import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����Applicacon Context
 * @author Admain
 *
 */
public class TestServletContext extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�õ�������context
		ServletContext Application=this.getServletContext();
		Integer accessCount=(Integer)Application.getAttribute("accessCount");
		//�����applicationδ����������Ϊ0���Ժ�ÿ�α�����һ��accessCouunt������һ��1
		if (accessCount==null) {
			accessCount=new Integer(0);
		}
		else {
			accessCount=new Integer(accessCount.intValue()+1);
		}
		Application.setAttribute("accessCount",accessCount);
		//��ӡ���ظ��ͻ��˵��ı�
		PrintWriter out=response.getWriter();
		out.println(accessCount);
		System.out.println("accessCount��ֵΪ��"+accessCount);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
}
