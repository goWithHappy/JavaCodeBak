package bulder;

public class SxtAirShipDirector implements AirShipDirector{
	//使用builder来创建产品
	AirShipBulider builder;
	public SxtAirShipDirector(AirShipBulider builder) {
		// TODO Auto-generated constructor stub
		this.builder=builder;
	}
	@Override
	public AirShip directAirShip() {
		Engine e=builder.builderEngine();
		OrbitalModle ob=builder.builderOribitalModule();
		EscapeTower es=builder.builderEscapeTower();
		//装配飞船对象
		AirShip as=new AirShip();
		as.setEngine(e);
		as.setEscapeTower(es);
		as.setOrbitalModle(ob);
		return as;
	}

}
