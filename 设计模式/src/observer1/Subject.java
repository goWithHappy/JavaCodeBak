package observer1;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Observer> list=new ArrayList<>();
	public void registerObserver(Observer obs){
		list.add(obs);
	}
	public void remove(Observer obs){
		list.remove(obs);
	}
	//֪ͨ�۲��߸���״̬
	public void notifyAllObservers(){
		for(Observer obs:list){
			obs.update(this);
		}
	}
}
