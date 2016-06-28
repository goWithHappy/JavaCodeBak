package com.test;

public class TestAnnotiation {
	//1.重写注解
	@Override
	public String toString(){
		return "";
	}
	//2.过时注解
	@Deprecated
	public static void test1(){
		
	}
	//3.抑制警告注解
	@SuppressWarnings("unused")
	public void test02(){
		int a;
	}
	@MyAnnotation01(studentAge = "")
	public void test03(){
		
	}
}
