package site.ihad.Jsoup;

import org.jsoup.nodes.Document;

import java.io.IOException;

import org.jsoup.Jsoup;

public class JsoupMain {
	public static void main(String[] args) {
		try {
			Document doc=Jsoup.connect("http://61.167.120.8:5555/login.htm").get();
			String source=doc.html();
			System.out.println(source);
		} catch (IOException e) {
			System.out.println("抓取页面异常！");
			e.printStackTrace();
		}
		
	}
}
