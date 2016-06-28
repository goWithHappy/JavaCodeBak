package test;

/**
 * 测试java.lang.Class对象的获取方式
 * @author Admain
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) {
		String path="bean.User";
		
		try {
			/**
			 * 同样一个类只能被加载一次
			 */
			//获取Class对象的方法:
			//1.
			Class clazz=Class.forName(path);
			System.out.println(clazz.hashCode());
			//2.
			Class clazz2=String.class;
			Class<? extends String> clazz3=path.getClass();
			System.out.println(clazz2.hashCode());
			System.out.println(clazz3.hashCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
