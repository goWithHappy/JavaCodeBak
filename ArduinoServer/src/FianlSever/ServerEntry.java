package FianlSever;

/**
 * ʹ�ö��̼߳���ͬʱ���������˿ڵķ��񣬶����ṩ����
 * @author Admain
 *
 */
public class ServerEntry extends Thread{
	private String name;
	private Server server;
	private int port;
	public ServerEntry(String name,Server server,int port) {
		this.name=name;
		this.server=server;
		this.port=port;
	}
	@Override
	public void run() {
		System.out.println("��������"+name+"������");
		server.start(port);
	}
	public static void main(String[] args) {
		ServerEntry arduinoServer=new ServerEntry("ArduinoServer", new ArduinoServer(), 8888);
		ServerEntry httpServer=new ServerEntry("HttpServer", new HttpServer(), 80);
		arduinoServer.start();
		httpServer.start();
	}
}
