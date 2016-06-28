package bulder;
/**
 * 实现AirShipBuilder接口
 * @author Admain
 *
 */
public class SxtAirShipBuilder implements AirShipBulider{

	@Override
	public Engine builderEngine() {
		// TODO Auto-generated method stub
		System.out.println("构建发动机");
		return new Engine("高档发动机");
	}

	@Override
	public OrbitalModle builderOribitalModule() {
		// TODO Auto-generated method stub
		System.out.println("构建轨道舱");
		return new OrbitalModle("高档轨道舱！");
	}

	@Override
	public EscapeTower builderEscapeTower() {
		// TODO Auto-generated method stub
		System.out.println("构建逃逸塔");
		return new EscapeTower("高档逃逸塔！");
	}

}
