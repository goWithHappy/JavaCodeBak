package proxy.staticProxy;
/**
 * 客户端只需要和经纪人来打交道
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
