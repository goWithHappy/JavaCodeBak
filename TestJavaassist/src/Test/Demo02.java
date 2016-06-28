package Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * 测试javaassist
 * @author Admain
 *
 */
public class Demo02 {
	/**
	 * 处理类的基本方法
	 * @throws NotFoundException 
	 * @throws CannotCompileException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException {
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.get("Test.EMP");
		//创建方法的两种方式:
		//方法一
//		CtMethod m1=CtMethod.make("public int add(int a,int b){return a+b;}",cc);
		//方法二
		CtMethod m=new CtMethod(CtClass.intType, "add",
				new CtClass[]{CtClass.intType,CtClass.intType},cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("System.out.println(\"执行了add方法\");return $2+$1");
		cc.addMethod(m);
		//通过发射来调用生成的方法
		Class claz=cc.toClass();
		Object obj=claz.newInstance(); //通过调用Emp无参构造器，创建新的Emp对象
		Method method=claz.getDeclaredMethod("add", int.class,int.class);
		
	}
}
