package FianlSever;

import java.util.HashMap;
import java.util.Map;

/**
 * Servlet的上下文(此时Map中存储的是对象很耗费IO性能)
 * 
 * @author Admain
 *
 */
public class ServletContext {
	// 为每一个servlet起一个别名
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
