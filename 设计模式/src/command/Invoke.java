package command;
/**
 * 命令的调用者和发起者
 * @author Admain
 *
 */
public class Invoke {
	private Command command;//可以通过List《command》来存放多个命令
	public Invoke(Command command) {
		super();
		this.command = command;
	}
	//用于调用命令的方法
	public void call(){
		command.execute();
	}
}
