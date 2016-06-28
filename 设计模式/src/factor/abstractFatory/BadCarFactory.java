package factor.abstractFatory;

public class BadCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		// TODO Auto-generated method stub
		return new BadEngine();
	}

	@Override
	public Seat createSeat() {
		// TODO Auto-generated method stub
		return new BadSeat();
	}
	
}
