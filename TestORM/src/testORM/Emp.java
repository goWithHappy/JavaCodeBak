package testORM;

import java.sql.Date;

/**
 * 与数据库中的emp表相互对应
 * @author Admain
 *
 */
public class Emp {
	private Integer id;
	private String empname;
	private Integer age;
	private Double salary;
	private String birthday;
	public Emp(Integer id, String empname, Integer age, Double salary, String birthday) {
		super();
		this.id = id;
		this.empname = empname;
		this.age = age;
		this.salary = salary;
		this.birthday = birthday;
	}
	public Emp(String empname, Integer age, Double salary, String birthday) {
		super();
		this.empname = empname;
		this.age = age;
		this.salary = salary;
		this.birthday = birthday;
	}
	public Emp() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String string) {
		this.birthday = string;
	}
	
}
