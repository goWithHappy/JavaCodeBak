package mediator;

public class Development implements Department{
	private Mediator m;
	public Development(Mediator m) {
		this.m=m;
		m.register("development", this);
	}
	@Override
	public void selfAction() {
		System.out.println("专心科研，研发新产品！");
	}

	@Override
	public void outAction() {
		System.out.println("give me money!");
	}

}
