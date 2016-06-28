package Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * ����javaassist
 * @author Admain
 *
 */
public class Demo02 {
	/**
	 * ������Ļ�������
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
		//�������������ַ�ʽ:
		//����һ
//		CtMethod m1=CtMethod.make("public int add(int a,int b){return a+b;}",cc);
		//������
		CtMethod m=new CtMethod(CtClass.intType, "add",
				new CtClass[]{CtClass.intType,CtClass.intType},cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("System.out.println(\"ִ����add����\");return $2+$1");
		cc.addMethod(m);
		//ͨ���������������ɵķ���
		Class claz=cc.toClass();
		Object obj=claz.newInstance(); //ͨ������Emp�޲ι������������µ�Emp����
		Method method=claz.getDeclaredMethod("add", int.class,int.class);
		
	}
}
