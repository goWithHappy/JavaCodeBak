package factor.simplefactory;

/**
 * ���Բ�ʹ�ù���ģʽ�������
 * @author Admain
 *
 */
public class NoFactory {
	public static void main(String[] args) {
		Car c1=new AoDi();
		Car c2=new Byd();
		c1.run();
		c2.run();
	}
}
