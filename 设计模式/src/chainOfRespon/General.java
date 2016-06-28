package chainOfRespon;

public class General extends Leader{

	public General(String name) {
		super(name);
	}

	@Override
	public void handRequest(LeaveRequest request) {
		if(request.getLeaveDays()>=10&&request.getLeaveDays()<30){
			System.out.println("员工"+request.getEmpName()+"请假天数："+request.getLeaveDays()+"理由"+request.getReason());
			System.out.println("总经理审批");
		}else{
			System.out.println("滚蛋，不同意！");
		}
	}
}
