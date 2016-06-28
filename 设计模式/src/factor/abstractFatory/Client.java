package factor.abstractFatory;
/**
 * 便于控制真个产品族
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
