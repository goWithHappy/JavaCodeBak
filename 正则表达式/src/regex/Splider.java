package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络爬虫(使用URL类可能会出现问题)
 * @author Admain
 *
 */
public class Splider {
	public static void main(String[] args) {
		String str=getSource("http://www.163.com");
	}
	public static String getSource(String myurl){
		StringBuffer source=new StringBuffer();
		String temp="";
		try {
			URL url=new URL(myurl);
			BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
			while(null!=(temp=reader.readLine())){
				source.append(temp);
				System.out.println(source);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			return source.toString();
		}
	}
}
