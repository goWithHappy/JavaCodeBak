import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletToJsp extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置属性并把它交给servletUse.jsp
		resp.setContentType("txt/html;charset=gb2312");
		req.setAttribute("ServletName", "servletTojsp");
		getServletConfig().getServletContext().getRequestDispatcher("/ServletUseJsp.jsp").forward(req, resp);
	}
	
}
