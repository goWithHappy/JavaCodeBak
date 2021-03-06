package template;

public abstract class BanktemplateMethod {
	//具体已经实现的方法
	public void takeNumber(){
		System.out.println("排队取号！");
	}
	public abstract void transact();//办理的具体业务
	public void evaluate(){
		System.out.println("反馈评分！！");
	}
	public final void process(){ //方法的具体处理步骤,一般final修饰
		this.takeNumber();
		this.transact();
		this.evaluate();
	}
}

