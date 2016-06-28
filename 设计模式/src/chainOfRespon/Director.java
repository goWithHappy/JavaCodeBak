package chainOfRespon;

public class Director extends Leader{

	public Director(String name) {
		super(name);
	}

	@Override
	public void handRequest(LeaveRequest request) {
		if(request.getLeaveDays()<3){
			System.out.println("Ա��"+request.getEmpName()+"���������"+request.getLeaveDays()+"����"+request.getReason());
			System.out.println("��������");
		}else{
			if(this.nextLeader!=null){
				this.nextLeader.handRequest(request);
			}
		}
	}

}
