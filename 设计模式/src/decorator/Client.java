package decorator;
/**
 * 
 * @author Admain
 *
 */
public class Client {
	public static void main(String[] args) {
		Car car=new Car();
		car.move();
		FlyCar flyCar=new FlyCar(car);
		flyCar.move();
	}
}
