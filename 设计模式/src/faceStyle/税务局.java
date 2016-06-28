package faceStyle;

public interface 税务局 {
	void taxCertificate();//办理税务登记证
}

class 北京税务局 implements 税务局{

	@Override
	public void taxCertificate() {
		// TODO Auto-generated method stub
		System.out.println("办理税务登记证！");
	}
	
}