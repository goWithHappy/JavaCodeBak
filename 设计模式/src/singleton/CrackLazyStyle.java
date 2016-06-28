package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 基于反射来破解懒汉式单例模式的漏洞
 * @author Admain
 *
 */
public class CrackLazyStyle {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		LazyStyle s1=LazyStyle.getInstance();
		LazyStyle s2=LazyStyle.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		//通过反射方式直接调用私有构造器
		Class<LazyStyle> clazz=(Class<LazyStyle>) Class.forName("singleton.LazyStyle");
		//只有存在公开的无参构造方法时才能通过clazz.newInstance()来生成对象
		Constructor<LazyStyle> c=clazz.getDeclaredConstructor(null);
		c.setAccessible(true); //跳过权限的检查
		LazyStyle s3=c.newInstance();
		LazyStyle s4=c.newInstance();
		System.out.println(s3);
		System.out.println(s4);
		
	}
}
