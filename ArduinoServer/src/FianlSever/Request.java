package FianlSever;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;


/**
 * ��Request���з�װ
 * @author Admain
 *
 */
public class Request {
	//�������ų���
	final private String CRLF="\r\n";
	final private String BLANK=" ";
	//������Ϣ
	private String requestInfo;
	//���󷽷�
	private String method;
	//������Դ
	private String url;
	//����
	private Map<String,LinkedList<String>> parameterValues;
	//������
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
			System.out.println("len�����ǣ�"+len);
			//���ͻ��˴��������д�뵽requestInfo��
			requestInfo=new String(data,0,len);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		//����ͷ��Ϣ����ȡ����Ҫ������
		parseRequestInfo();
	}
	/**
	 * ����ͷ��Ϣ�ķ���
	 */
	private void parseRequestInfo(){
		if(null==requestInfo || (requestInfo.trim().equals(""))){
			return;
		}
		/**
		 * ======================
		 * ��������Ϣ�зֽ��������ʽ������·�������������get��ʽ���ܴ��ڣ�
		 * ���Ϊpost��ʽ������ʽ������������Ĳ���
		 * ======================
		 */
		String paramString="";		//�����������
		/**
		 * ��ȡ����ʽ
		 */
		String firstLine=requestInfo.substring(0,requestInfo.indexOf(CRLF));
		int idx=firstLine.indexOf("/"); // / ��λ��
		this.method=firstLine.substring(0, idx).trim();
		/**
		 * ��ȡurl
		 */
		String urlString=firstLine.substring(idx,firstLine.indexOf("HTTP"));
		if(this.method.equalsIgnoreCase("POST")){
			this.url=urlString;
			paramString=requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
		}
		else if(this.method.equalsIgnoreCase("GET")){
			if(urlString.contains("?")){                //�ж��Ƿ��в���
				String[] urlArry=urlString.split("\\?");
				this.url=urlArry[0];
				paramString=urlArry[1];	//�����������
			}
			else{
				this.url=urlString;
			}
		}
		
		//���ַ���д�뵽Map���
		if(paramString!=""){
			parrseParams(paramString);
		}
 	}
	/**
	 * ����в����͵��ø÷��������ַ���д�뵽Map��
	 * @param paramString
	 */
	private void parrseParams(String paramString){
		//�ָ���ַ���ת��������
		StringTokenizer token=new StringTokenizer(paramString,"&");
		//�����洢valueֵ
		while(token.hasMoreTokens()){
			LinkedList<String> value=new LinkedList<>();
			String keyValue=token.nextToken();
			String [] keyValues=keyValue.split("=");
			if(2==keyValues.length){
				value.add(decode(keyValues[1].trim(),"gbk"));
				System.out.println(decode(keyValues[1].trim(),"gbk"));
			}
			else if(1==keyValues.length){
				//���û�в���������Ϊ""
				value.add("");
			}
			//ת��ΪMap
			if(!parameterValues.containsKey(keyValues[0])){
				parameterValues.put(keyValues[0], value);
			}
		}
	}
	/**
	 * �����������
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
		 *Ϊurl����get����
		 * @return
		 */
		public String getUrl() {
			System.out.println(url);
			return url;
		}
		/**
		 * ���ز���ֵ
		 * @param key
		 * @return
		 */
		public String getParameter(String key){
			LinkedList<String> value=parameterValues.get(key);
			return value.getFirst();
		}
}
