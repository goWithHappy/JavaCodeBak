package prototype;

import java.util.Date;

/**
 * 原型模式：深复制
 * @author Admain
 *
 */
public class Client2 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Sheep2 s1=new Sheep2("s1", new Date(19950903L));
		Sheep2 s2=(Sheep2) s1.clone();
		System.out.println(s1.getName());
		s1.setName("s");
		System.out.println(s1.getName());
		System.out.println(s2.getName());
	}
}
