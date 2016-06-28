import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestLifeCycleServlet extends HttpServlet{
	
	
	@Override
	public void destroy() {
		System.out.println("函数被destory");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("调用init方法！");
	}

	public TestLifeCycleServlet() {
		System.out.println("调用了构造函数！");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("调用doGet方法！");
	}
	
}
