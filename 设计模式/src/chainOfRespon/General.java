package chainOfRespon;

public class General extends Leader{

	public General(String name) {
		super(name);
	}

	@Override
	public void handRequest(LeaveRequest request) {
		if(request.getLeaveDays()>=10&&request.getLeaveDays()<30){
			System.out.println("Ա��"+request.getEmpName()+"���������"+request.getLeaveDays()+"����"+request.getReason());
			System.out.println("�ܾ�������");
		}else{
			System.out.println("��������ͬ�⣡");
		}
	}
}
