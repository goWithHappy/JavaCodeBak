package template;

public class Client {
	public static void main(String[] args) {
		 BanktemplateMethod bak=new DropMoney();
		 bak.process();
	}
}
class DropMoney extends BanktemplateMethod{

	@Override
	public void transact() {
		System.out.println("我要取款！！");
	}
	
}