package bulder;

/**
 * ������ģʽ���������ɴ�
 * @author Admain
 *
 */
public class AirShip {
	private OrbitalModle orbitalModle; //�����
	private Engine engine;//������
	private EscapeTower escapeTower;
	public OrbitalModle getOrbitalModle() {
		return orbitalModle;
	}
	public void setOrbitalModle(OrbitalModle orbitalModle) {
		this.orbitalModle = orbitalModle;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public EscapeTower getEscapeTower() {
		return escapeTower;
	}
	public void setEscapeTower(EscapeTower escapeTower) {
		this.escapeTower = escapeTower;
	}
	
}
//�����
class OrbitalModle{
	private String name;
	public OrbitalModle(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
//������
class Engine{
	private String name;
	public Engine(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
}
//������
class EscapeTower{
	private String name;
	public EscapeTower(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
}
