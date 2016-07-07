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
			Method m=c.getDeclaredMethod("get"+StringUtils.firstChar2UpperCase(fileName), null);
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
	/**
	 * 通过反射来调用对应属性的set方法
	 * @param obj
	 * @param columnName
	 * @param columnValue
	 */
	public static void invokeSet(Object obj,String columnName,Object columnValue){
		try {
			if(columnValue!=null){
				Method m=obj.getClass().getDeclaredMethod("set"+StringUtils.firstChar2UpperCase(columnName),columnValue.getClass());
				m.invoke(obj, columnValue);
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	}
}
