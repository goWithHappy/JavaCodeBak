package strategy;

public class NewCustromerManyStratefy implements Strategy{

	@Override
	public double getPrice(double standPrice) {
		System.out.println("新客户大量购买，打九折！！");
		return standPrice*0.9;
	}

}
