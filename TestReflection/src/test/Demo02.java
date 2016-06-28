package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import bean.User;

/**
 * 运用反射的API获取反射的信息（类的名字 属性 构造器）
 * @author Admain
 *
 */
public class Demo02 {
	static String path="bean.User";
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		try {
			Class clazz=Class.forName(path);
			
			//获取类的名字
			System.out.println(clazz.getName()); //得到路径，以及全名
			System.out.println(clazz.getSimpleName());//仅仅得到名称
			//获得属性
			Field[] f=clazz.getFields();   //获取public属性
			System.out.println(f.length);
			f=clazz.getDeclaredFields();
			System.out.println(f.length);
			for(Field field:f){
				System.out.println(field);
			}
			//获取方法
			Method [] m=clazz.getMethods();
			System.out.println(m.length);
			for(Method method:m){
				System.out.println(method);
			}
			//使用构造器创建实例
			Constructor<User> c2=clazz.getConstructor(int.class,int.class,String.class);
			c2.newInstance(100,100,"侧四"); //在获取对象时传入对应构造器的参数
			//获得构造器
			Constructor[] c=clazz.getDeclaredConstructors();
			System.out.println(c.length);
			for(Constructor constructor:c){
				System.out.println(constructor);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
