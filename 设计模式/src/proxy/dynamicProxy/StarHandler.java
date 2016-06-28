package proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import javax.jws.Oneway;

public class StarHandler implements InvocationHandler{
	private Star realstar;
	public StarHandler(Star realstar) {
		this.realstar=realstar;
	}
	/**
	 * ���Ĵ����������̴�����Ҫͨ���÷�����ʵ��
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object object=null;
		System.out.println("��̸");
		System.out.println("��Ԥ����");
		if(method.getName().equals("sing")){
			object=method.invoke(realstar, args);
		}
		System.out.println("��β��");
		return object;
	}

}
