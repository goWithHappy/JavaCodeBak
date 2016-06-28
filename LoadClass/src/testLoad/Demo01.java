package testLoad;

/**
 * 测试类的加载过程
 * @author Admain
 *
 */
public class Demo01 {
	static{
		System.out.println("静态初始化Demo01");
	}
	public static void main(String[] args) throws ClassNotFoundException {
		String a="aaaaaaaaaa";
		//主动引用：
//		new A();
//		System.out.println(A.width);
//		Class.forName("testLoad.A");
		//被动引用
		System.out.println(A.max);
	}
}
class A extends B{
	public A() {
		System.out.println("执行构造方法！");
	}
	public static int width=100;
	public static final int max=100;
	static{
		System.out.println("静态初始化A");
		width=300;
		System.out.println(B.m);
	}
}
class B{
	public static String m="ceshi";
	static{
		System.out.println("静态构B");
	}
}
