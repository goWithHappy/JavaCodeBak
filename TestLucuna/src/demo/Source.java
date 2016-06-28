package demo;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.IOContext;
import org.apache.lucene.store.IndexInput;
import org.apache.lucene.store.Lock;

/**
 * 存储被搜素的基本资源
 * 由于所看的视频版本不对无法进行代码的编写，此处就不再进行实现，可以参考下边的参考
 * http://www.cnblogs.com/xing901022/p/3933675.html
 * 
 * @author Admain
 *
 */
public class Source {
	public void createIndex(){
		//模拟网页1的内容
		String page1_title="my first";
		String page1_content="search is a simple thing!";
		String page1_url="http:www.ihad.site";
		//模拟网页2的内容
		String page2_title="my first";
		String page2_content="search is a simple thing!";
		String page2_url="http:www.ihad.site";
		//建立索引为每一个网页都建立一个Document
		
	}
}
