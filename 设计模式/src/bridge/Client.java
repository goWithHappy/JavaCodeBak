package bridge;
/**
 * 测试桥接模式
 * @author Admain
 *
 */
public class Client {
	public static void main(String[] args) {
		Computer c=new Laptop(new Lenovo());   //来表示联想笔记本
		c.sale();
	}
}
