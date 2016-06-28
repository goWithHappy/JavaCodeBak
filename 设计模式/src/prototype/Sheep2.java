package prototype;

import java.util.Date;

/**
 * ԭ��ģʽ(deep clone)
 * @author Admain
 *
 */
public class Sheep2 implements Cloneable{
	private String name;
	private Date birthday;
	public Sheep2(String name,Date birthday) {
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
		Sheep2 s=(Sheep2) super.clone();
		s.birthday=(Date) this.birthday.clone(); //���������Խ���������clone
		return super.clone();
	}
}
