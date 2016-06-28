package FianlSever;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;


/**
 * 对Request进行封装
 * @author Admain
 *
 */
public class Request {
	//两个符号常量
	final private String CRLF="\r\n";
	final private String BLANK=" ";
	//请求信息
	private String requestInfo;
	//请求方法
	private String method;
	//请求资源
	private String url;
	//参数
	private Map<String,LinkedList<String>> parameterValues;
	//输入流
	InputStream is;
	public Request() {
		method="";
		url="";
		parameterValues=new HashMap<String, LinkedList<String>>();
	}
	public Request(InputStream is){
		this();
		this.is=is;
		try {
			byte [] data=new byte[20480];
			int len=is.read(data);
			System.out.println("len长度是："+len);
			//将客户端传入的数据写入到requestInfo中
			requestInfo=new String(data,0,len);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		//分析头信息，提取所需要的数据
		parseRequestInfo();
	}
	/**
	 * 分析头信息的方法
	 */
	private void parseRequestInfo(){
		if(null==requestInfo || (requestInfo.trim().equals(""))){
			return;
		}
		/**
		 * ======================
		 * 从请求信息中分解出：请求方式、请求路径、请求参数（get方式可能存在）
		 * 如果为post方式，请求方式可能在最后正文部分
		 * ======================
		 */
		String paramString="";		//接受请求参数
		/**
		 * 获取请求方式
		 */
		String firstLine=requestInfo.substring(0,requestInfo.indexOf(CRLF));
		int idx=firstLine.indexOf("/"); // / 的位置
		this.method=firstLine.substring(0, idx).trim();
		/**
		 * 获取url
		 */
		String urlString=firstLine.substring(idx,firstLine.indexOf("HTTP"));
		if(this.method.equalsIgnoreCase("POST")){
			this.url=urlString;
			paramString=requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
		}
		else if(this.method.equalsIgnoreCase("GET")){
			if(urlString.contains("?")){                //判断是否有参数
				String[] urlArry=urlString.split("\\?");
				this.url=urlArry[0];
				paramString=urlArry[1];	//接受请求参数
			}
			else{
				this.url=urlString;
			}
		}
		
		//将字符串写入到Map里边
		if(paramString!=""){
			parrseParams(paramString);
		}
 	}
	/**
	 * 如果有参数就调用该方法，将字符串写入到Map中
	 * @param paramString
	 */
	private void parrseParams(String paramString){
		//分割，将字符串转换成数组
		StringTokenizer token=new StringTokenizer(paramString,"&");
		//用来存储value值
		while(token.hasMoreTokens()){
			LinkedList<String> value=new LinkedList<>();
			String keyValue=token.nextToken();
			String [] keyValues=keyValue.split("=");
			if(2==keyValues.length){
				value.add(decode(keyValues[1].trim(),"gbk"));
				System.out.println(decode(keyValues[1].trim(),"gbk"));
			}
			else if(1==keyValues.length){
				//如果没有参数则设置为""
				value.add("");
			}
			//转换为Map
			if(!parameterValues.containsKey(keyValues[0])){
				parameterValues.put(keyValues[0], value);
			}
		}
	}
	/**
	 * 结局中文问题
	 * @param value
	 * @param code
	 * @return
	 */
		private String decode(String value,String code){
			try {
				return java.net.URLDecoder.decode(value,code);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return null;
		}
		/**
		 *为url设置get方法
		 * @return
		 */
		public String getUrl() {
			System.out.println(url);
			return url;
		}
		/**
		 * 返回参数值
		 * @param key
		 * @return
		 */
		public String getParameter(String key){
			LinkedList<String> value=parameterValues.get(key);
			return value.getFirst();
		}
}
