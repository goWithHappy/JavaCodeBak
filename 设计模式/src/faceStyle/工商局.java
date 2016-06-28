package faceStyle;

public interface 工商局 {
	void orgCodeCertificate();
}
class 北京工商局 implements 工商局{

	@Override
	public void orgCodeCertificate() {
		// TODO Auto-generated method stub
		System.out.println("办理组织机构代码证！！");
	}
	
}
