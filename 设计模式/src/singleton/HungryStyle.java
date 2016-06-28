package singleton;

/**
 * 饿汉式单例模式
 * @author Admain
 *
 */
public class HungryStyle {
	//类初始化时立即进行加载,天然线程安全，调用效率高
	private static HungryStyle instance=new HungryStyle(); 
	private HungryStyle() {
	}
	//方法没有同步效率高
	public static HungryStyle  getInstance(){
		return instance;
	}
}

