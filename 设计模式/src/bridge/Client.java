package bridge;
/**
 * �����Ž�ģʽ
 * @author Admain
 *
 */
public class Client {
	public static void main(String[] args) {
		Computer c=new Laptop(new Lenovo());   //����ʾ����ʼǱ�
		c.sale();
	}
}
