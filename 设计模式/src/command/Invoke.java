package command;
/**
 * ����ĵ����ߺͷ�����
 * @author Admain
 *
 */
public class Invoke {
	private Command command;//����ͨ��List��command������Ŷ������
	public Invoke(Command command) {
		super();
		this.command = command;
	}
	//���ڵ�������ķ���
	public void call(){
		command.execute();
	}
}
