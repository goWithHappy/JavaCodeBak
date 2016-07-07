package adapter;

import bridge.Brand;

/**
 * 客户端类相当于笔记本,本身是兼容target接口的
 * @author Admain
 *
 */
public class Client {
	public void test(Target t){
		t.handleReq();
	}
	public static void main(String[] args) {
		Client c=new Client();
//		Adapter a=new Adapter();
		Adapter2 a=new Adapter2(new Adaptee());
		c.test(a);
	}
}
