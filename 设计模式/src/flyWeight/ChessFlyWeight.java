package flyWeight;
/**
 * ��Ԫ��
 * @author Admain
 *
 */
public interface ChessFlyWeight {
	void setColor(String color);
	String getColor();
	void disply(Coordinate c);
}
class ConcreteChess implements ChessFlyWeight{
	private String color;
	public ConcreteChess(String color) {
		this.color=color;
	}
	@Override
	public void setColor(String color) {
		this.color=color;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void disply(Coordinate c) {
		System.out.println("������ɫ��"+color);
		System.out.println("����λ�ã�"+c.getX()+"---"+c.getY());
	}
	
} 