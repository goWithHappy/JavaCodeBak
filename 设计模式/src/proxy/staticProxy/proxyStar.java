package proxy.staticProxy;

/**
 * �����࣬�������ǵĴ���
 * @author Admain
 *
 */
public class proxyStar implements Star{
	private Star star;
	/**
	 * ���췽��
	 */
	public proxyStar(Star star) {
		this.star=star;
	}
	@Override
	public void confer() {
		System.out.println("proxyStar.confer");
	}

	@Override
	public void signConstract() {
		// TODO Auto-generated method stub
		System.out.println("proxyStar.signConstract");
	}

	@Override
	public void bookTicket() {
		// TODO Auto-generated method stub
		System.out.println("proxyStar.bookTicket");
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		star.sing();
	}

	@Override
	public void collectMoney() {
		// TODO Auto-generated method stub
		System.out.println("proxyStar.collectMoney");
	}
	
}
