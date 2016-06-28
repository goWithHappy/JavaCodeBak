package observer1;

public class ObserverA implements Observer{
	private int myState;
	@Override
	public void update(Subject subject) {
		myState=((ConcreteSubjective)subject).getState();
	}
	public int getMyState() {
		return myState;
	}
	public void setMyState(int myState) {
		this.myState = myState;
	}
	
}
