package com.ihad.site;

public class Demo03 {
	public static void main(String[] args) {
		Out out=new Out();
		out.test();
		out.test02(new Car(){
			@Override
			public void run() {
				System.out.println("参数内部类子类在跑");
			}
		});
	}
}
class Out{
	//参数式
	public void test02(Car car){
		car.run();
	}
	//继承式
	public void test(){
		Car car=new Car(){
			public void run() {
				System.out.println("子类的车子在跑");
			};
		};
		car.run();
	}
}
class Car{
	public void run(){
		System.out.println("汽车跑！！");
	}
}
