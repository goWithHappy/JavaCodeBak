package strategy;

public class NewCustromerFewStratey implements Strategy{

	@Override
	public double getPrice(double standPrice) {
		System.out.println("����̫�ٲ����ۣ���");
		return standPrice;
	}

}
