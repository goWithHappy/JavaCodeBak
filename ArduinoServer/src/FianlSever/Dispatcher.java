package FianlSever;

import java.io.IOException;
import java.net.Socket;

/**
 * �ַ�������������߳�����
 * @author Admain
 *
 */
public class Dispatcher implements Runnable{
	private Socket client=null;
	private Request req=null;
	private Response rep=null;
	int code=200;	//Ĭ��code��200������������������Ϊ
	
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
		//ͨ���ӿڻص���Ӧ�Բ�ͬ�ķ�������
		Servlet servlet = null;
		try {
			servlet = WebApp.getServlet(req.getUrl());
			System.out.println("req.getUrl()"+req.getUrl());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("ʵ����ʧ�ܣ���");
		}
		//�жϷ��ص�sevlet�Ƿ�Ϊ�գ����Ϊ����ֱ�ӳ���404����û�еķ���·����������Ӧ
		if(servlet==null){
			this.code=404;
			rep.pushToClient(code);
			System.out.println("�Ҳ�����Ӧ·������");
		}
		servlet.service(req, rep);
		rep.pushToClient(code); //�������ͻ���
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
			this.code=500;
			rep.pushToClient(code);
		}
	}
}
