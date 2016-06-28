package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import bean.User;

/**
 * ���÷����API��ȡ�������Ϣ��������� ���� ��������
 * @author Admain
 *
 */
public class Demo02 {
	static String path="bean.User";
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		try {
			Class clazz=Class.forName(path);
			
			//��ȡ�������
			System.out.println(clazz.getName()); //�õ�·�����Լ�ȫ��
			System.out.println(clazz.getSimpleName());//�����õ�����
			//�������
			Field[] f=clazz.getFields();   //��ȡpublic����
			System.out.println(f.length);
			f=clazz.getDeclaredFields();
			System.out.println(f.length);
			for(Field field:f){
				System.out.println(field);
			}
			//��ȡ����
			Method [] m=clazz.getMethods();
			System.out.println(m.length);
			for(Method method:m){
				System.out.println(method);
			}
			//ʹ�ù���������ʵ��
			Constructor<User> c2=clazz.getConstructor(int.class,int.class,String.class);
			c2.newInstance(100,100,"����"); //�ڻ�ȡ����ʱ�����Ӧ�������Ĳ���
			//��ù�����
			Constructor[] c=clazz.getDeclaredConstructors();
			System.out.println(c.length);
			for(Constructor constructor:c){
				System.out.println(constructor);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
