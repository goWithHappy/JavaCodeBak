package flyWeight;

public class Client {
	public static void main(String[] args) {
		ChessFlyWeight chess=ChessFlyWeightFactoy.getChess("黑色");
		ChessFlyWeight chess2=ChessFlyWeightFactoy.getChess("黑色");
		System.out.println(chess);
		System.out.println(chess2);
		System.out.println("增加外部的状态！============");
		chess.disply(new Coordinate(10,11));
		chess2.disply(new Coordinate(20, 50));
	}
}
