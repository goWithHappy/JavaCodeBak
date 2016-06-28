package factor.factoryMethod;

/**
 * 用来生产奥迪
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
