package singleton;

/**
 * 静态内部类实现方式
 * @author Admain
 *
 */
public class StaticInnerClass {
	private StaticInnerClass(){}
	//内部类天然线程安全，没有同步代码块效率高
	private static class innerClass{
		private static final StaticInnerClass instance=new StaticInnerClass(); 
	}
	public static StaticInnerClass getInstance(){
		return innerClass.instance;
	}
}
