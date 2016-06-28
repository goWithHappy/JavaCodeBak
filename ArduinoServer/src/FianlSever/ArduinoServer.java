package FianlSever;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 增加对各种Servlet的映射，各种类的封装
 * @author Admain
 *
 */
public class ArduinoServer {
	private ServerSocket server=null;
	private boolean isShutdown=false;
	/**
	 *启动服务器
	 */
	private void start(int port){
		try {
			server=new ServerSocket(port);
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 接受客户端响应
	 * @throws IOException 
	 */
	private void receive() throws IOException{
		int i=0;
		String info;
		while(!isShutdown){
			Socket client=server.accept();
			info=anylize(client.getInputStream());
			System.out.println("当前经度");
		}
	}
	//接受请求信息，并解析
	public String anylize(InputStream is){
		String requestInfo = null;
		byte [] data=new byte[20480];
		int len;
		try {
			len = is.read(data);
			//将客户端传入的数据写入到requestInfo中
			requestInfo=new String(data,0,len);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(requestInfo!=null) return requestInfo;
			else return null;
		}
	}
}
