package command;

public interface Command {
	/**
	 * �����������Ϊ�յķ���
	 * ʵ����Ŀ�������������Ʋ�ͬ�ķ���
	 */
	void execute();
}
class CommandCommand implements Command{
	private Receiver receiver; //����������ִ����
	public CommandCommand(Receiver receiver) {
		this.receiver=receiver;
	}
	@Override
	public void execute() {
		//����ִ��ǰ�������еĲ���
		receiver.action();
	}
	
}
