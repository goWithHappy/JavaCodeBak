package factor.factoryMethod;
/**
 * �������ǵ�
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
