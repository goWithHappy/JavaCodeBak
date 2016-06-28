package faceStyle;

/**
 * 使用外观模式之后注册公司
 * @author Admain
 *
 */
public class Client2 {
	public static void main(String[] args) {
		RegisterFacade register=new RegisterFacade();
		register.regist();
	}
}
