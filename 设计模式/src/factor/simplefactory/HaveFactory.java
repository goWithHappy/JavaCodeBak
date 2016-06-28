package factor.simplefactory;
/**
 * 在使用简单工厂的实现
 * @author Admain
 *
 */
public class HaveFactory {
	public static void main(String[] args) {
		Car c1=new CreateCar().createCar("奥迪");
		Car c2=new CreateCar().createCar("比亚迪");
		c1.run();
		c2.run();
	}
}
