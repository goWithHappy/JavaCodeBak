package factor.simplefactory;
/**
 * ��ʹ�ü򵥹�����ʵ��
 * @author Admain
 *
 */
public class HaveFactory {
	public static void main(String[] args) {
		Car c1=new CreateCar().createCar("�µ�");
		Car c2=new CreateCar().createCar("���ǵ�");
		c1.run();
		c2.run();
	}
}
