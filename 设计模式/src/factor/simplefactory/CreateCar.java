package factor.simplefactory;

/**
 * 测试有工厂的实现
 * @author Admain
 *
 */
public class CreateCar {
	/**
	 * 实现方式1通过传入参数来判断车的种类
	 * @param type
	 * @return
	 */
	public Car createCar(String type){
		if("奥迪".equals(type)) return new AoDi();
		else if("比亚迪".equals(type)) return new Byd();
		else return null;
	}
	/**
	 * 通过不同的静态方法来得到不同的车
	 */
	public static Car getByd(){
		return new Byd();
	}
	public static Car getAodi(){
		return new AoDi();
	}
}
