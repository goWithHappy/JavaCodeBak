package vo;

/**
 * �������Ĳ�ѯ��ʹ�õ�bean
 * @author Admain
 *
 */
public class EmpVo {
	private Integer id;
	private String empname;
	private Double xinxshui;
	private Integer age;
	private String deptName;
	private String deptAddr;
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
	public Double getXinxshui() {
		return xinxshui;
	}
	public void setXinxshui(Double xinxshui) {
		this.xinxshui = xinxshui;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptAddr() {
		return deptAddr;
	}
	public void setDeptAddr(String deptAddr) {
		this.deptAddr = deptAddr;
	}
	public EmpVo(Integer id, String empname, Double xinxshui, Integer age, String deptName, String deptAddr) {
		super();
		this.id = id;
		this.empname = empname;
		this.xinxshui = xinxshui;
		this.age = age;
		this.deptName = deptName;
		this.deptAddr = deptAddr;
	}
	public EmpVo() {
	}
}
