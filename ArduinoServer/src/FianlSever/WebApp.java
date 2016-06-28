package FianlSever;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class WebApp {
	private static ServletContext context=new ServletContext();
	static{
				//��ý�������
				SAXParserFactory factory=SAXParserFactory.newInstance();
				//��ȡ������
				SAXParser parser = null;
				try {
					parser = factory.newSAXParser();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//ָ��xml�Ӵ�����
				WebHandler web=new WebHandler();
				try {
					parser.parse(Thread.currentThread().getContextClassLoader()
							.getResourceAsStream("FianlSever/web.xml"), web);
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		Map<String,String> mapping=context.getMapping();
		Map<String, String> servlet=context.getServlet();
		for(Entity entity:web.getEntityList()){
			servlet.put(entity.getServletName(), entity.getUrl());
			System.out.println("entity.getServletName():"+entity.getServletName());
			System.out.println("entity.getUrl():"+entity.getUrl());
		}
		//��listת��Ϊmap�洢��mapping��
		for(Mapping map:web.getMappingList()){
			List<String> urls=map.getUrlPattern();
			for(String url:urls){
				mapping.put(url, map.getServletName());
				System.out.println("url:"+url);
				System.out.println("map.getServletName()"+map.getServletName());
			}
		}
	}
	//����url��ȡ����Ӧ��Servlet
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		if((null==url)||(url.equals(""))){
			return null;
		}
		//ͨ�����䶯̬�Ĵ�������
		String OName=context.getServlet().get(context.getMapping().get(url.trim()).trim());
		return (Servlet)Class.forName(OName).newInstance();
	}

}
