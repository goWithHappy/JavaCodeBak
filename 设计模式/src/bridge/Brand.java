package bridge;

public interface Brand {
	void sale();
}

class Lenovo implements Brand{

	@Override
	public void sale() {
		System.out.println("����������ԣ���");
	}
	
}
class Dell implements Brand{

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("���۴������ԣ�");
	}
	
}
