package decorator;

//抽象构建角色
public interface ICar {
	void move();
}
//被装饰对象
class Car implements ICar{
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("路上跑！");
	}
	
}
class SuperCar implements ICar{
	private ICar car;
	public SuperCar(ICar car) {
		this.car=car;
	}
	@Override
	public void move() {
		car.move();
	}
	
}
class FlyCar extends SuperCar{

	public FlyCar(ICar car) {
		super(car);
	}
	/**
	 * 需要而外增加的功能
	 */
	public void fly(){
		System.out.println("可以飞！");
	}
	@Override
	public void move() {
		super.move();
		fly();
	}
}
class AICar extends SuperCar{

	public AICar(ICar car) {
		super(car);
	}
	@Override
	public void move() {
		super.move();
		System.out.println("可以自己跑！");
	}
}