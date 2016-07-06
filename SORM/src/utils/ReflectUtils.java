package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 封装类反射常用的操作
 * @author Admain
 *
 */
public class ReflectUtils {
	/**
	 * 调用obj属性的fileName的get方法
	 * @param fileName
	 * @param obj
	 * @return
	 */
	public static Object invokeGet(String fileName,Object obj){
		Class c=obj.getClass();
		try {
			Method m=c.getMethod("get"+StringUtils.firstChar2UpperCase(fileName), null);
			try {
				return m.invoke(obj, null);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
