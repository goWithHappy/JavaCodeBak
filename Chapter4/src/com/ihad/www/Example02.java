package com.ihad.www;

public class Example02 {
	public static void main(String[] args) {
		Dog dog=new Dog();
		dog.shout();
		
	}
}
class Animal{
	void shout(){
		System.out.println("动物发出声音！");
	}
}
class Dog extends Animal{
	void shout(){
		System.out.println("小狗发出汪汪的声音！");
		super.shout();
	}
}
