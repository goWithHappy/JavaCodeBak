package command;

public interface Command {
	/**
	 * 这个方法返回为空的方法
	 * 实际项目根据需求可以设计不同的方法
	 */
	void execute();
}
class CommandCommand implements Command{
	private Receiver receiver; //命令真正的执行者
	public CommandCommand(Receiver receiver) {
		this.receiver=receiver;
	}
	@Override
	public void execute() {
		//命令执行前后所进行的操作
		receiver.action();
	}
	
}
