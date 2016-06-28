package mediator;

public class Client {
	public static void main(String[] args) {
		Mediator m=new President();
		Market market=new Market(m);
		Development devp=new Development(m);
		Finacial finace=new Finacial(m);
		devp.outAction();
	}
}
