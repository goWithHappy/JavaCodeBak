package observer2;

import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer{
	private int myState;
	@Override
	public void update(Observable o, Object arg) {
		myState=((ConcreteSubjective)o).getState();
	}

}
