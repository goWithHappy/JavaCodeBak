package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
	public static void main(String[] args) {
		//�ҳ��ַ�������
		String s="www.baidu.com123";
		//���ʽ����
		Pattern p=Pattern.compile("\\w123");
		//����Matcher����
		Matcher m=p.matcher(s);
		boolean ishave=m.matches(); //���Խ������ַ����������ģʽƥ��
		boolean hasNext=m.find(); //Ѱ����һ��
		System.out.println(ishave);
		System.out.println(hasNext);
		System.out.println(m.group()); //�����ַ�������,group�ǲ�ͬ���飬��������ʽ����������������
		//�滻
		String newStr=m.replaceAll("#");
		System.out.println(newStr);
	}
}
