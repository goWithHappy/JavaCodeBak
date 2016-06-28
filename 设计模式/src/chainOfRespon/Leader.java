package chainOfRespon;

/**
 * �쵼�ĳ�����
 * @author Admain
 *
 */
public abstract class Leader {
	protected String name;
	protected Leader nextLeader;//�洢��һ���쵼
	public Leader(String name) {
		this.name=name;
	}
	//��������������һ������
	public void setNextLeader(Leader nextLeader){
		this.nextLeader=nextLeader;
	}
	/**
	 * ��������ĺ��ķ���
	 */
	public abstract void handRequest(LeaveRequest request);
}
