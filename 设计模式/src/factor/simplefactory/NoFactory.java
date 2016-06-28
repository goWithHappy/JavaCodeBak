package factor.simplefactory;

/**
 * 测试不使用工厂模式的情况下
 * @author Admain
 *
 */
public class NoFactory {
	public static void main(String[] args) {
		Car c1=new AoDi();
		Car c2=new Byd();
		c1.run();
		c2.run();
	}
}
