package FianlSever;

import java.util.ArrayList;
import java.util.List;

/**
 * Ϊ����web.xml��׼��
 * @author Admain
 *
 */
public class Mapping {
	private String servletName;
	private List<String> urlPattern;
	public Mapping() {
		urlPattern=new ArrayList<String>();
	}
	public String getServletName() {
		return servletName;
	}
	public void setServletName(String servletName) {
		this.servletName = servletName;
	}
	public List<String> getUrlPattern() {
		return urlPattern;
	}
	public void setUrlPattern(List<String> urlPattern) {
		this.urlPattern = urlPattern;
	}
	
}
