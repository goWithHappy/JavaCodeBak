package test;

/**
 * ����java.lang.Class����Ļ�ȡ��ʽ
 * @author Admain
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) {
		String path="bean.User";
		
		try {
			/**
			 * ͬ��һ����ֻ�ܱ�����һ��
			 */
			//��ȡClass����ķ���:
			//1.
			Class clazz=Class.forName(path);
			System.out.println(clazz.hashCode());
			//2.
			Class clazz2=String.class;
			Class<? extends String> clazz3=path.getClass();
			System.out.println(clazz2.hashCode());
			System.out.println(clazz3.hashCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
