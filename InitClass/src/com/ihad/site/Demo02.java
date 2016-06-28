package com.ihad.site;

public class Demo02 {
	//成员内部类的创建方式
	outerClass out=new outerClass();
	outerClass.InnerClass in=out.new InnerClass();
}
class outerClass{
	
	public class InnerClass{
		void say(){
			System.out.println("内部类"+this);
		}
	}
}