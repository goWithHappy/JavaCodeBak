package demo;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.IOContext;
import org.apache.lucene.store.IndexInput;
import org.apache.lucene.store.Lock;

/**
 * �洢�����صĻ�����Դ
 * ������������Ƶ�汾�����޷����д���ı�д���˴��Ͳ��ٽ���ʵ�֣����Բο��±ߵĲο�
 * http://www.cnblogs.com/xing901022/p/3933675.html
 * 
 * @author Admain
 *
 */
public class Source {
	public void createIndex(){
		//ģ����ҳ1������
		String page1_title="my first";
		String page1_content="search is a simple thing!";
		String page1_url="http:www.ihad.site";
		//ģ����ҳ2������
		String page2_title="my first";
		String page2_content="search is a simple thing!";
		String page2_url="http:www.ihad.site";
		//��������Ϊÿһ����ҳ������һ��Document
		
	}
}
