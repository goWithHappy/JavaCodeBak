package FianlSever;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WebHandler extends DefaultHandler{
	private List<Entity> entityList;
	private List<Mapping> mappingList;
	private Entity entity;
	private Mapping map;
	private boolean isMap;
	String tag=null;  //用来存储解析中间值
	
	@Override
	public void startDocument() throws SAXException {
		//文档解析开始
		entityList=new ArrayList<>();
		mappingList=new ArrayList<>();
	}

	@Override
	public void endDocument() throws SAXException {
		//文档解析结束
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//元素解析开始
		if (null!=qName) {
			tag=qName;
		}
		if(qName.equals("servlet")){
			isMap=false;
			entity=new Entity();
		}
		else if(qName.equals("mapping")){
			map=new Mapping();
			isMap=true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//元素解析结束
		if(qName.equals("servlet")){
			entityList.add(entity);
		}
		else if(qName.equals("mapping")){
			mappingList.add(map);
		}
		tag=null;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//得到元素解析结果的地方,处理内容的地方
		/*
		 * 是Map时的处理
		 */
		if(null!=tag){
			String str=new String(ch,start,length);
			if(isMap){
				if(tag.equals("servlet-name")){
					map.setServletName(str);
				}
				else if(tag.equals("url-pattern")){
					//获得Arrylist并将str插入其中
					map.getUrlPattern().add(str);
				}
			}
			else{
				if(tag.equals("servlet-name")){
					entity.setServletName(str);
				}
				else if(tag.equals("servlet-class")){
					entity.setUrl(str);
				}
			}
		}
	}
	
	public List<Entity> getEntityList() {
		return entityList;
	}

	public List<Mapping> getMappingList() {
		return mappingList;
	}


	//创建main方法进行测试
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//获得解析工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//获取解析器
		SAXParser parser=factory.newSAXParser();
		//指定xml加处理器
		WebHandler handler=new WebHandler();
		parser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("FianlSever/web.xml"), handler);
		List<Entity> entitys=handler.getEntityList();
		List<Mapping> mappings=handler.getMappingList();
		for(int i=0;i<mappings.size();i++){
			System.out.println("ServletName:"+mappings.get(i).getServletName());
			System.out.println("UrlPattern"+mappings.get(i).getUrlPattern());
		}
		for(int i=0;i<entitys.size();i++){
			System.out.println("ServleName:"+entitys.get(i).servletName);
			System.out.println("servlet-class"+entitys.get(i).getUrl());
		}
	}
	
}
