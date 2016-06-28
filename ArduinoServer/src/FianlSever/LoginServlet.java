package FianlSever;

public class LoginServlet extends Servlet{

	@Override
	public void doGet(Request req, Response rep) {
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		System.out.println("用户名："+req.getParameter("uname"));
		System.out.println("密码："+req.getParameter("pwd"));
		if(login(name, pwd)){
			rep.println("<html><head><title>欢迎成功</title>");
			rep.println("<head><body>").print("现在是登陆页面！！").print("</body></html>");
		}
		else{
			rep.print("<html><head><title>登陆失败</title>");
			rep.print("<head><body>").print("你输入的用户名或则密码错误请重新登陆").print("</body></html>");
		} 
			
	}

	@Override
	public void doPost(Request req, Response rep) {
		this.doGet(req, rep);
	}
	/**
	 * 判断用户名以及密码是否正确
	 */
	public boolean login(String name,String pwd){
		return name.equals("tom")&&pwd.equals("123");
	}
	

}
