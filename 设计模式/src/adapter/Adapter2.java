package adapter;

/**
 * ʹ�������ʵ��
 * @author Admain
 *
 */
public class Adapter2 implements Target{
	private Adaptee a;
	public Adapter2(Adaptee a) {
		// TODO Auto-generated constructor stub
		this.a=a;
	}
	@Override
	public void handleReq() {
		// TODO Auto-generated method stub
		a.request();
	}

}
