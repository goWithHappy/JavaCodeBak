package observer2;

import java.util.Observable;

/**
 * ʹ�ùٷ��ṩ�Ľӿ���ʵ��
 * @author Admain
 *
 */
public class ConcreteSubjective extends Observable{
	private int state;
	public void set(int state){
		this.state=state;
		this.setChanged();  //��ʾĿ������Ѿ�����
		this.notifyObservers();//֪ͨ���й۲���
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
