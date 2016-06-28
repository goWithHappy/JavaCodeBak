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
		//��������
		CtField f1=CtField.make("private int emotion;", cc);
		cc.addField(f1);
		//��������
		CtMethod m1=CtMethod.make("public int getEmotion(){return emotion;}", cc);
		cc.addMethod(m1);
		
		//����������
		CtConstructor constructor=new CtConstructor(new CtClass[]{CtClass.intType},cc );
		constructor.setBody("{this.emotion=emotion;}");
		cc.addConstructor(constructor);
		cc.writeFile("c:/");
	}
}
