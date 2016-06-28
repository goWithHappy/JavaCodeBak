package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
	public static void main(String[] args) {
		//找出字符串数组
		String s="www.baidu.com123";
		//表达式对象
		Pattern p=Pattern.compile("\\w123");
		//创建Matcher对象
		Matcher m=p.matcher(s);
		boolean ishave=m.matches(); //尝试将整个字符串序列与该模式匹配
		boolean hasNext=m.find(); //寻找下一个
		System.out.println(ishave);
		System.out.println(hasNext);
		System.out.println(m.group()); //返回字符串内容,group是不同分组，以正则表达式的括号内容来分组
		//替换
		String newStr=m.replaceAll("#");
		System.out.println(newStr);
	}
}
