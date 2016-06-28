package FianlSever;

public class RegisterServlet extends Servlet {

	@Override
	public void doGet(Request req, Response rep) {
		rep.println("<html><head><title>欢迎注册</title>");
		rep.println("<head><body>").print("现在是注册页面！！").print("</body></html>");
	}

	@Override
	public void doPost(Request req, Response rep) {
		rep.println("<html><head><title>欢迎注册</title>");
		rep.println("<head><body>").print("现在是注册页面！！").print("</body></html>");
	}

}
