package testLoad;

/**
 * ������ļ��ع���
 * @author Admain
 *
 */
public class Demo01 {
	static{
		System.out.println("��̬��ʼ��Demo01");
	}
	public static void main(String[] args) throws ClassNotFoundException {
		String a="aaaaaaaaaa";
		//�������ã�
//		new A();
//		System.out.println(A.width);
//		Class.forName("testLoad.A");
		//��������
		System.out.println(A.max);
	}
}
class A extends B{
	public A() {
		System.out.println("ִ�й��췽����");
	}
	public static int width=100;
	public static final int max=100;
	static{
		System.out.println("��̬��ʼ��A");
		width=300;
		System.out.println(B.m);
	}
}
class B{
	public static String m="ceshi";
	static{
		System.out.println("��̬��B");
	}
}
