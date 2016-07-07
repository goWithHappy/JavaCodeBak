package FianlSever;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import between.BackInfo;
import between.CurrentInfo;

/**
 * 增加对各种Servlet的映射，各种类的封装
 * @author Admain
 *
 */
public class ArduinoServer implements Server{
	private ServerSocket server=null;
	private boolean isShutdown=false;
	/**
	 *启动服务器
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
	 * 接受客户端响应
	 * @throws IOException 
	 */
	public void receive() throws IOException{
		int i=0;
		String info=null;
		System.out.println("arduino服务开启成功");
		while(!isShutdown){
			Socket client=server.accept();
			info=anylize(client.getInputStream());
			if(info!=null){
				CurrentInfo.add(info);
				System.out.println("得到的坐标信息为："+info);
				/**
				 * 将收到的信息写入到数据库中进行备份
				 */
				String [] cureentInfo=info.split(",");
				BackInfo.insert(cureentInfo);
			}
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
