package factor.abstractFatory;
/**
 * ���ڿ��������Ʒ��
 * @author Admain
 *
 */
public class Client {
	public static void main(String[] args) {
		CarFactory c=new LuxuryCarFactory();
		Seat s=c.createSeat();
		s.massage();
		Engine e=c.createEngine();
		e.start();
		e.run();
	}
}
