package chainOfRespon;

/**
 * 领导的抽象类
 * @author Admain
 *
 */
public abstract class Leader {
	protected String name;
	protected Leader nextLeader;//存储下一个领导
	public Leader(String name) {
		this.name=name;
	}
	//设置责任链的下一条对象
	public void setNextLeader(Leader nextLeader){
		this.nextLeader=nextLeader;
	}
	/**
	 * 处理请求的核心方法
	 */
	public abstract void handRequest(LeaveRequest request);
}
