package observer1;

public class ConcreteSubjective extends Subject{
	private int state;

	public int getState() {
		return state;
	}

	//目标对象状态发成改变则会通知所有观察者
	public void setState(int state) {
		this.state = state;
		this.notifyAllObservers();
	}
}
