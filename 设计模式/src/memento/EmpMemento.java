package memento;

/**
 * ±¸ÍüÂ¼Àà
 * @author Admain
 *
 */
public class EmpMemento {
	private String name;
	private int age;
	private int salary;
	
	public EmpMemento(Emp e) {
		this.age=e.getAge();
		this.name=e.getName();
		this.salary=e.getSalary();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
