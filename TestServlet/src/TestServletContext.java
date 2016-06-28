import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试Applicacon Context
 * @author Admain
 *
 */
public class TestServletContext extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到本机的context
		ServletContext Application=this.getServletContext();
		Integer accessCount=(Integer)Application.getAttribute("accessCount");
		//如果该application未被访问设置为0，以后每次被访问一次accessCouunt均加上一个1
		if (accessCount==null) {
			accessCount=new Integer(0);
		}
		else {
			accessCount=new Integer(accessCount.intValue()+1);
		}
		Application.setAttribute("accessCount",accessCount);
		//打印返回给客户端的文本
		PrintWriter out=response.getWriter();
		out.println(accessCount);
		System.out.println("accessCount的值为："+accessCount);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
}
