package prototype;

import java.util.Date;

/**
 * 原型模式
 * @author Admain
 *
 */
public class Sheep implements Cloneable{
	private String name;
	private Date birthday;
	public Sheep(String name,Date birthday) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.birthday=birthday;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}
}
