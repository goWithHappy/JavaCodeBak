package beans;

/**
 * 封装了java属性和get；set属性的源码
 * @author Admain
 *
 */
public class JavaFieldGetSet {
	/**
	 * 属性的源码信息 public int getUserInt
	 */
	private String fieldInfo;
	/**
	 * get的方法源码 public getUserId
	 */
	private String getInfo;
	/**
	 * set方法的源码信息 public void setUserId(int id){this.id=id}
	 */
	private String setInfo;
	public String getFieldInfo() {
		return fieldInfo;
	}
	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}
	public String getGetInfo() {
		return getInfo;
	}
	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}
	public String getSetInfo() {
		return setInfo;
	}
	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}
	public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
		super();
		this.fieldInfo = fieldInfo;
		this.getInfo = getInfo;
		this.setInfo = setInfo;
	}
	public JavaFieldGetSet() {
	}
	/**
	 * 重写toString方法方便调试
	 */
	@Override
	public String toString() {
		System.out.println(fieldInfo);
		System.out.println(getInfo);
		System.out.println(setInfo);
		return super.toString();
	}
}
