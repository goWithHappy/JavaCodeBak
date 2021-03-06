package observer2;

import java.util.Observable;

/**
 * 使用官方提供的接口来实现
 * @author Admain
 *
 */
public class ConcreteSubjective extends Observable{
	private int state;
	public void set(int state){
		this.state=state;
		this.setChanged();  //表示目标对象已经更改
		this.notifyObservers();//通知所有观察者
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
