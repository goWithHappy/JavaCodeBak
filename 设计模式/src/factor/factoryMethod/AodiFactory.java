package factor.factoryMethod;

/**
 * ���������µ�
 * @author Admain
 *
 */
public class AodiFactory implements CarFactory{

	@Override
	public Car createCar() {
		// TODO Auto-generated method stub
		return new AoDi();
	}
	
}
