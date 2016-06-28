package strategy;

public class OldCustomerFewStrategy implements Strategy{

	@Override
	public double getPrice(double standPrice) {
		System.out.println("老客户小批量，打八五折！！");
		return 0;
	}
	
}
