package singleton;

/**
 * ����ʽ����ģʽ
 * @author Admain
 *
 */
public class HungryStyle {
	//���ʼ��ʱ�������м���,��Ȼ�̰߳�ȫ������Ч�ʸ�
	private static HungryStyle instance=new HungryStyle(); 
	private HungryStyle() {
	}
	//����û��ͬ��Ч�ʸ�
	public static HungryStyle  getInstance(){
		return instance;
	}
}

