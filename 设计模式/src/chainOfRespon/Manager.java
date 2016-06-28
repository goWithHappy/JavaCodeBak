package chainOfRespon;

public class Manager extends Leader{

	public Manager(String name) {
		super(name);
	}

	@Override
	public void handRequest(LeaveRequest request) {
		if(request.getLeaveDays()>=3&&request.getLeaveDays()<10){
			System.out.println("员工"+request.getEmpName()+"请假天数："+request.getLeaveDays()+"理由"+request.getReason());
			System.out.println("经理审批"+this.name);
		}else{
			if(this.nextLeader!=null){
				this.nextLeader.handRequest(request);
			}
		}
	}
}
