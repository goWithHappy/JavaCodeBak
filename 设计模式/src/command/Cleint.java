package command;

public class Cleint {
	public static void main(String[] args) {
		Command c=new CommandCommand(new Receiver());
		Invoke i=new Invoke(c);
		i.call();
	}
}
