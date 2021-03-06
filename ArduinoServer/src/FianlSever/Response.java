package FianlSever;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

/**
 * 封装响应信息
 * @author Admain
 *
 */
public class Response {
	final private String CRLF="\r\n";
	final private String BLANK=" ";
	//存储头信息
	private StringBuilder headInfo;
	//存储正文信息
	private StringBuilder content;
	//存储正文长度
	private int len=0;
	//构建流
	private BufferedWriter bw;
	public Response() {
		headInfo=new StringBuilder();
		content=new StringBuilder();
		len=0;
	}
	public Response(OutputStream os) {
		this();
		//初始化流
		bw=new BufferedWriter(new OutputStreamWriter(os));
	}
	
	/**
	 * 构建正文
	 */
	public Response print(String info){
		content.append(info);
		//获取正文的同时增加正文的长度
		len+=info.getBytes().length;
		return this;
	}
	/**
	 * 构建正文+回车
	 */
	public Response println(String info){
		content.append(info).append(CRLF);
		len+=info.getBytes().length;
		return this;
	}
	/**
	 * 构建响应头
	 */
	private void createHeadInfo(int code){
		//(1、协议版本号、状态吗、描述
		headInfo.append("HTTP/1.1").append(BLANK).append(code).append(CRLF);
		switch(code){
		case 200:
			headInfo.append("ok");
			break;
		case 404:
			headInfo.append("NOT FOUND!");
			break;
		case 500:
			headInfo.append("Server has init error!!");
			break;
		}
		headInfo.append(CRLF);
		//响应头
		headInfo.append("Sever:mysownSever tomcat/6.0.12").append(CRLF);
		//时间
		headInfo.append("Date:").append(new Date()).append(CRLF);
		//编码
		headInfo.append("Content-Type:").append("text/html;").append("charset=gbk2312").append(CRLF);
		//正文长度
		headInfo.append("Content-Length:").append(len).append(CRLF);
		headInfo.append(CRLF); //分割符
	}
	void pushToClient(int code){
		//构建出头信息
		createHeadInfo(code);
		//头信息+分隔符
		try {
			bw.append(headInfo.toString());
			//正文
			bw.append(content.toString());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("push to client error!!");
		}
	}
}
