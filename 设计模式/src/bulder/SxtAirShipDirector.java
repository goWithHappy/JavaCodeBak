package bulder;

public class SxtAirShipDirector implements AirShipDirector{
	//ʹ��builder��������Ʒ
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
		//װ��ɴ�����
		AirShip as=new AirShip();
		as.setEngine(e);
		as.setEscapeTower(es);
		as.setOrbitalModle(ob);
		return as;
	}

}
