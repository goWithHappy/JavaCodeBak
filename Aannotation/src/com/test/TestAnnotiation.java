package com.test;

public class TestAnnotiation {
	//1.��дע��
	@Override
	public String toString(){
		return "";
	}
	//2.��ʱע��
	@Deprecated
	public static void test1(){
		
	}
	//3.���ƾ���ע��
	@SuppressWarnings("unused")
	public void test02(){
		int a;
	}
	@MyAnnotation01(studentAge = "")
	public void test03(){
		
	}
}
