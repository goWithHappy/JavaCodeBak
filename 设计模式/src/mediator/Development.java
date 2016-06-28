package mediator;

public class Development implements Department{
	private Mediator m;
	public Development(Mediator m) {
		this.m=m;
		m.register("development", this);
	}
	@Override
	public void selfAction() {
		System.out.println("ר�Ŀ��У��з��²�Ʒ��");
	}

	@Override
	public void outAction() {
		System.out.println("give me money!");
	}

}
