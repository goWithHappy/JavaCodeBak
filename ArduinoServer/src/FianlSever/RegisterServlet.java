package FianlSever;

public class RegisterServlet extends Servlet {

	@Override
	public void doGet(Request req, Response rep) {
		rep.println("<html><head><title>��ӭע��</title>");
		rep.println("<head><body>").print("������ע��ҳ�棡��").print("</body></html>");
	}

	@Override
	public void doPost(Request req, Response rep) {
		rep.println("<html><head><title>��ӭע��</title>");
		rep.println("<head><body>").print("������ע��ҳ�棡��").print("</body></html>");
	}

}
