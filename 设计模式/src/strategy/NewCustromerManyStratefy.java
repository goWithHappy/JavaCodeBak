package strategy;

public class NewCustromerManyStratefy implements Strategy{

	@Override
	public double getPrice(double standPrice) {
		System.out.println("�¿ͻ��������򣬴���ۣ���");
		return standPrice*0.9;
	}

}
