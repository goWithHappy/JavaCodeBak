package adapter;

import bridge.Brand;

/**
 * �ͻ������൱�ڱʼǱ�,�����Ǽ���target�ӿڵ�
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
