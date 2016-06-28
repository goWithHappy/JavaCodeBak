package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ���ڷ������ƽ�����ʽ����ģʽ��©��
 * @author Admain
 *
 */
public class CrackLazyStyle {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		LazyStyle s1=LazyStyle.getInstance();
		LazyStyle s2=LazyStyle.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		//ͨ�����䷽ʽֱ�ӵ���˽�й�����
		Class<LazyStyle> clazz=(Class<LazyStyle>) Class.forName("singleton.LazyStyle");
		//ֻ�д��ڹ������޲ι��췽��ʱ����ͨ��clazz.newInstance()�����ɶ���
		Constructor<LazyStyle> c=clazz.getDeclaredConstructor(null);
		c.setAccessible(true); //����Ȩ�޵ļ��
		LazyStyle s3=c.newInstance();
		LazyStyle s4=c.newInstance();
		System.out.println(s3);
		System.out.println(s4);
		
	}
}
