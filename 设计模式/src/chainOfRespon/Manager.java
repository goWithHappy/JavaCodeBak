package chainOfRespon;

public class Manager extends Leader{

	public Manager(String name) {
		super(name);
	}

	@Override
	public void handRequest(LeaveRequest request) {
		if(request.getLeaveDays()>=3&&request.getLeaveDays()<10){
			System.out.println("Ա��"+request.getEmpName()+"���������"+request.getLeaveDays()+"����"+request.getReason());
			System.out.println("��������"+this.name);
		}else{
			if(this.nextLeader!=null){
				this.nextLeader.handRequest(request);
			}
		}
	}
}
