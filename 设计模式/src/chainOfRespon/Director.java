package chainOfRespon;

public class Director extends Leader{

	public Director(String name) {
		super(name);
	}

	@Override
	public void handRequest(LeaveRequest request) {
		if(request.getLeaveDays()<3){
			System.out.println("员工"+request.getEmpName()+"请假天数："+request.getLeaveDays()+"理由"+request.getReason());
			System.out.println("主任审批");
		}else{
			if(this.nextLeader!=null){
				this.nextLeader.handRequest(request);
			}
		}
	}

}
