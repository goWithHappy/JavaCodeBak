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
	String tag=null;  //�����洢�����м�ֵ
	
	@Override
	public void startDocument() throws SAXException {
		//�ĵ�������ʼ
		entityList=new ArrayList<>();
		mappingList=new ArrayList<>();
	}

	@Override
	public void endDocument() throws SAXException {
		//�ĵ���������
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//Ԫ�ؽ�����ʼ
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
		//Ԫ�ؽ�������
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
		//�õ�Ԫ�ؽ�������ĵط�,�������ݵĵط�
		/*
		 * ��Mapʱ�Ĵ���
		 */
		if(null!=tag){
			String str=new String(ch,start,length);
			if(isMap){
				if(tag.equals("servlet-name")){
					map.setServletName(str);
				}
				else if(tag.equals("url-pattern")){
					//���Arrylist����str��������
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


	//����main�������в���
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//��ý�������
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//��ȡ������
		SAXParser parser=factory.newSAXParser();
		//ָ��xml�Ӵ�����
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
