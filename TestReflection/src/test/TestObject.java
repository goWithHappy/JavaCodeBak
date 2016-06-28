package test;

import bean.User;

/**
 * ��̬�Ĵ�������
 * @author Admain
 *
 */
public class TestObject {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		try {
			Class<User> clazz=(Class<User>) Class.forName("bean.User");
			User user=clazz.newInstance();
			System.out.println(user.getAge());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
