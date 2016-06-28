package singleton;

import java.io.Serializable;

/**
 * 懒汉式
 * @author Admain
 *
 */
public class LazyStyle implements Serializable{
	//类初始化时，不初始化创建对象，真正调用的时候再进行初始化
	private static LazyStyle instance;
	private LazyStyle() {
		if(instance!=null){
			throw new RuntimeException();
		}
	}
	//有同步代码块，多线程调用时效率比较低
	public static synchronized LazyStyle getInstance(){
		if(instance==null){
			instance=new LazyStyle();
		}
		return instance;
	}
	//防止通过反序列化方式来进行破解
	private Object readResolve(){
		return instance;
	}
}
