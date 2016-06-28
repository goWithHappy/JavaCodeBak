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
	//通知观察者更新状态
	public void notifyAllObservers(){
		for(Observer obs:list){
			obs.update(this);
		}
	}
}
