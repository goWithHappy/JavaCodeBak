package proxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * 通过jdk自带方法来实现动态代理
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
