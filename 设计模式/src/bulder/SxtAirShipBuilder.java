package bulder;
/**
 * ʵ��AirShipBuilder�ӿ�
 * @author Admain
 *
 */
public class SxtAirShipBuilder implements AirShipBulider{

	@Override
	public Engine builderEngine() {
		// TODO Auto-generated method stub
		System.out.println("����������");
		return new Engine("�ߵ�������");
	}

	@Override
	public OrbitalModle builderOribitalModule() {
		// TODO Auto-generated method stub
		System.out.println("���������");
		return new OrbitalModle("�ߵ�����գ�");
	}

	@Override
	public EscapeTower builderEscapeTower() {
		// TODO Auto-generated method stub
		System.out.println("����������");
		return new EscapeTower("�ߵ���������");
	}

}
