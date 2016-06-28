package bulder;

/**
 * 建造者模式，来创建飞船
 * @author Admain
 *
 */
public class AirShip {
	private OrbitalModle orbitalModle; //轨道舱
	private Engine engine;//发动机
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
//轨道舱
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
//发动机
class Engine{
	private String name;
	public Engine(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
}
//逃逸塔
class EscapeTower{
	private String name;
	public EscapeTower(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
}
