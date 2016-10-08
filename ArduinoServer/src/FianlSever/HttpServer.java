package FianlSever;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���ӶԸ���Servlet��ӳ�䣬������ķ�װ
 * @author Admain
 *
 */
public class HttpServer implements Server{
	private ServerSocket server=null;
	private boolean isShutdown=false;
	public static void main(String[] args) {
		HttpServer server=new HttpServer();
		ArduinoServer arduServer=new ArduinoServer();
		server.start(80);
		arduServer.start(8888);
		System.out.println("arduino���ʶ˿�Ϊ8888");
		System.out.println("Http�ṩ�ķ��ʶ˿�Ϊ��80");
	}
	/**
	 *����������
	 */
	@Override
	public void start(int port){
		try {
			server=new ServerSocket(port);
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ���ܿͻ�����Ӧ
	 * @throws IOException 
	 */
	private void receive() throws IOException{
		int i=0;
		System.out.println("HTTP�������ɹ���");
		while(!isShutdown){
			try {
				//��ȡ�ͻ������Ӳ������߳�
				new Thread(new Dispatcher(server.accept())).start();
				System.out.println("�����߳���"+(++i));
			} catch (IOException e) {
				e.printStackTrace();
				isShutdown=true;
				System.out.println("��ȡ�ͻ�����������ʧ�ܣ���");
			}
		}
	}
}