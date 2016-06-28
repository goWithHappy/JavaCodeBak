package proxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * ͨ��jdk�Դ�������ʵ�ֶ�̬����
 */
public class Client {
	public static void main(String[] args) {
		Star realStar=new RealStar();
		StarHandler hander=new StarHandler(realStar);
		Star proxy=(Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Star.class} ,hander);
		proxy.bookTicket();
		proxy.sing();
	}
}
