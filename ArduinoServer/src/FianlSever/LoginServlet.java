package FianlSever;

public class LoginServlet extends Servlet{

	@Override
	public void doGet(Request req, Response rep) {
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		System.out.println("�û�����"+req.getParameter("uname"));
		System.out.println("���룺"+req.getParameter("pwd"));
		if(login(name, pwd)){
			rep.println("<html><head><title>��ӭ�ɹ�</title>");
			rep.println("<head><body>").print("�����ǵ�½ҳ�棡��").print("</body></html>");
		}
		else{
			rep.print("<html><head><title>��½ʧ��</title>");
			rep.print("<head><body>").print("��������û�������������������µ�½").print("</body></html>");
		} 
			
	}

	@Override
	public void doPost(Request req, Response rep) {
		this.doGet(req, rep);
	}
	/**
	 * �ж��û����Լ������Ƿ���ȷ
	 */
	public boolean login(String name,String pwd){
		return name.equals("tom")&&pwd.equals("123");
	}
	

}
