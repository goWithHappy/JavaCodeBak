package factor.factoryMethod;
/**
 * 生产比亚迪
 * @author Admain
 *
 */
public class BydFactory implements CarFactory{

	@Override
	public Car createCar() {
		// TODO Auto-generated method stub
		return new Byd();
	}
	
}
