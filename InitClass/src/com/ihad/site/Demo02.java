package com.ihad.site;

public class Demo02 {
	//��Ա�ڲ���Ĵ�����ʽ
	outerClass out=new outerClass();
	outerClass.InnerClass in=out.new InnerClass();
}
class outerClass{
	
	public class InnerClass{
		void say(){
			System.out.println("�ڲ���"+this);
		}
	}
}