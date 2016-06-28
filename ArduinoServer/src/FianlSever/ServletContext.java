package FianlSever;

import java.util.HashMap;
import java.util.Map;

/**
 * Servlet��������(��ʱMap�д洢���Ƕ���ܺķ�IO����)
 * 
 * @author Admain
 *
 */
public class ServletContext {
	// Ϊÿһ��servlet��һ������
	// login -->loginServlet
	private Map<String, String> servlet;
	// url-->login
	// /log-->login
	private Map<String, String> mapping;

	public ServletContext() {
		mapping = new HashMap<String,String>();
		servlet = new HashMap<String,String>();
	}

	public Map<String, String> getServlet() {
		return servlet;
	}
	public void setServlet(Map<String, String> servlet) {
		this.servlet=servlet;
	}

	public Map<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	

}
