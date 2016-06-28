package factor.abstractFatory;

public class LuxuryCarFactory implements CarFactory{

	@Override
	public Engine createEngine() {
		// TODO Auto-generated method stub
		return new LuckyEngine();
	}

	@Override
	public Seat createSeat() {
		// TODO Auto-generated method stub
		return new LuckySeat();
	}

}
