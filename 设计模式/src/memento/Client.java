package memento;

public class Client {
	public static void main(String[] args) {
		CareTaker taker=new CareTaker();
		Emp emp=new Emp("tom", 12, 100000);
		System.out.println("��һ��:"+emp.getName()+"--"+emp.getAge()+"--"+emp.getSalary());
		taker.setMemento(emp.memeto(emp));
		emp.setAge(19);
		emp.setName("Jack");
		System.out.println("�ڶ���:"+emp.getName()+"--"+emp.getAge()+"--"+emp.getSalary());
		emp.recover(taker.getMemento());
		System.out.println("������:"+emp.getName()+"--"+emp.getAge()+"--"+emp.getSalary());
	}
}
