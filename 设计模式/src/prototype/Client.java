package prototype;

import java.util.Date;

/**
 * ����ԭ��ģʽ
 * @author Admain
 *
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		Sheep s1=new Sheep("����",new Date(1231233L));
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		Sheep s2=(Sheep)s1.clone();
		System.out.println(s2);
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
	}
}
