package com.ihad.www;

public class Example02 {
	public static void main(String[] args) {
		Dog dog=new Dog();
		dog.shout();
		
	}
}
class Animal{
	void shout(){
		System.out.println("���﷢��������");
	}
}
class Dog extends Animal{
	void shout(){
		System.out.println("С������������������");
		super.shout();
	}
}
