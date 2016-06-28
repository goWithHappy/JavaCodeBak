package decorator;

//���󹹽���ɫ
public interface ICar {
	void move();
}
//��װ�ζ���
class Car implements ICar{
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("·���ܣ�");
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
	 * ��Ҫ�������ӵĹ���
	 */
	public void fly(){
		System.out.println("���Էɣ�");
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
		System.out.println("�����Լ��ܣ�");
	}
}