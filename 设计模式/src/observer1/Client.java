package observer1;

import java.io.ObjectInputValidation;

public class Client {
	public static void main(String[] args) {
		//目标对象
		ConcreteSubjective subjective=new ConcreteSubjective();
		
		//创建多个观察者
		ObserverA obs1=new ObserverA();
		ObserverA obs2=new ObserverA();
		ObserverA obs3=new ObserverA();
		ObserverA obs4=new ObserverA();
		//注册
		subjective.registerObserver(obs1);
		subjective.registerObserver(obs2);
		subjective.registerObserver(obs3);
		subjective.registerObserver(obs4);
		//改变subject的状态
		subjective.setState(3000);
		System.out.println(obs1.getMyState());
		System.out.println(obs2.getMyState());
		System.out.println(obs3.getMyState());
		System.out.println(obs4.getMyState());
	}
}
