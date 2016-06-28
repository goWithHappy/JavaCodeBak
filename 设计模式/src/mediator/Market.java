package mediator;

public class Market implements Department{
	private Mediator m;
	public Market(Mediator m) {
		this.m=m;
		m.register("market", this);
	}
	@Override
	public void selfAction() {
		System.out.println("进行市场调研！！");
		m.command("finacial");
	}

	@Override
	public void outAction() {
		System.out.println("汇报调研情况！！!");
	}
}
