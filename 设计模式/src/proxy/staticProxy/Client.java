package proxy.staticProxy;
/**
 * �ͻ���ֻ��Ҫ�;��������򽻵�
 * @author Admain
 *
 */
public class Client {
	public static void main(String[] args) {
		Star proxy=new proxyStar(new RealStar());
		proxy.bookTicket();
		proxy.collectMoney();
		proxy.confer();
		proxy.sing();
		proxy.collectMoney();
	}
}
