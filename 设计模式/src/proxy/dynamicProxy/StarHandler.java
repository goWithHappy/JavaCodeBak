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
	 * 核心处理方法，流程处理都需要通过该方法来实现
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object object=null;
		System.out.println("面谈");
		System.out.println("手预付款");
		if(method.getName().equals("sing")){
			object=method.invoke(realstar, args);
		}
		System.out.println("收尾款");
		return object;
	}

}
