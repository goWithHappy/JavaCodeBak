package com.ihad.site;

/**
 * 测试内部类
 * @author Admain
 *
 */
public class Demo01 {
	//静态内部类
	private static class test{
		
	}
	//普通内部类
	private class FieldInnerClass{}
	void sayhello(){
		//方法内部类（局部内部类）
		class test{
			
		}
	}
	//匿名内部类
	Runnable runnable=new Runnable() {
		
		@Override
		public void run() {
			
		}
	};
}
