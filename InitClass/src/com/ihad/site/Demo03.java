package com.ihad.site;

public class Demo03 {
	public static void main(String[] args) {
		Out out=new Out();
		out.test();
		out.test02(new Car(){
			@Override
			public void run() {
				System.out.println("�����ڲ�����������");
			}
		});
	}
}
class Out{
	//����ʽ
	public void test02(Car car){
		car.run();
	}
	//�̳�ʽ
	public void test(){
		Car car=new Car(){
			public void run() {
				System.out.println("����ĳ�������");
			};
		};
		car.run();
	}
}
class Car{
	public void run(){
		System.out.println("�����ܣ���");
	}
}
