package memento;

public class Client {
	public static void main(String[] args) {
		CareTaker taker=new CareTaker();
		Emp emp=new Emp("tom", 12, 100000);
		System.out.println("第一次:"+emp.getName()+"--"+emp.getAge()+"--"+emp.getSalary());
		taker.setMemento(emp.memeto(emp));
		emp.setAge(19);
		emp.setName("Jack");
		System.out.println("第二次:"+emp.getName()+"--"+emp.getAge()+"--"+emp.getSalary());
		emp.recover(taker.getMemento());
		System.out.println("第三次:"+emp.getName()+"--"+emp.getAge()+"--"+emp.getSalary());
	}
}
