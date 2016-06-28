package memento;
/**
 * Դ������
 * @author Admain
 *
 */
public class Emp {
	private String name;
	private int age;
	private int salary;
	public Emp(String name, int age, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
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
	//��������
	public EmpMemento memeto(Emp e){
		return new EmpMemento(this);
	}
	//�������ݻָ�
	public void recover(EmpMemento mmt)
	{
		this.name=mmt.getName();
		this.age=mmt.getAge();
		this.salary=mmt.getSalary();
	}
}
