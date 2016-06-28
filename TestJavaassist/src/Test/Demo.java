package Test;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

public class Demo {
	public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
		ClassPool pool=ClassPool.getDefault();
		CtClass cc=pool.makeClass("Test.EMP");
		//创建属性
		CtField f1=CtField.make("private int emotion;", cc);
		cc.addField(f1);
		//创建方法
		CtMethod m1=CtMethod.make("public int getEmotion(){return emotion;}", cc);
		cc.addMethod(m1);
		
		//创建构造器
		CtConstructor constructor=new CtConstructor(new CtClass[]{CtClass.intType},cc );
		constructor.setBody("{this.emotion=emotion;}");
		cc.addConstructor(constructor);
		cc.writeFile("c:/");
	}
}
