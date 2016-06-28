package chainOfRespon;

/**
 * 测试其使用
 * @author Admain
 *
 */
public class Client {
	public static void main(String[] args) {
		Leader a=new Director("张三");
		Leader b=new Manager("李四");
		Leader c=new General("王五");
		//设置责任链模式
		a.setNextLeader(b);
		b.setNextLeader(c);
		//开始请假
		LeaveRequest leave=new LeaveRequest();
		leave.setEmpName("王明");
		leave.setLeaveDays(29);
		leave.setReason("早产！");
		a.handRequest(leave);
	}
}
