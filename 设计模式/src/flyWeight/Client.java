package flyWeight;

public class Client {
	public static void main(String[] args) {
		ChessFlyWeight chess=ChessFlyWeightFactoy.getChess("��ɫ");
		ChessFlyWeight chess2=ChessFlyWeightFactoy.getChess("��ɫ");
		System.out.println(chess);
		System.out.println(chess2);
		System.out.println("�����ⲿ��״̬��============");
		chess.disply(new Coordinate(10,11));
		chess2.disply(new Coordinate(20, 50));
	}
}
