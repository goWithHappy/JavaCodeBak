package FianlSever;

import java.io.IOException;
import java.net.Socket;

/**
 * 分发器用来处理多线程问题
 * @author Admain
 *
 */
public class Dispatcher implements Runnable{
	private Socket client=null;
	private Request req=null;
	private Response rep=null;
	int code=200;	//默认code是200，若出现问题则设置为
	
	public Dispatcher(Socket client) {
		this.client = client;
		try {
			req=new Request(client.getInputStream());
			rep=new Response(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			code=500;
		}
	}
	
	@Override
	public void run() {
		//通过接口回调来应对不同的访问请求
		Servlet servlet = null;
		try {
			servlet = WebApp.getServlet(req.getUrl());
			System.out.println("req.getUrl()"+req.getUrl());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("实例化失败！！");
		}
		//判断返回的sevlet是否为空，如果为空则直接出现404，即没有的访问路径不进行响应
		if(servlet==null){
			this.code=404;
			rep.pushToClient(code);
			System.out.println("找不到响应路径！！");
		}
		servlet.service(req, rep);
		rep.pushToClient(code); //推送至客户端
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
			this.code=500;
			rep.pushToClient(code);
		}
	}
}
