package faceStyle;

public interface 质监局 {
	void checkName();
}

class 北京质监局 implements 质监局{

	@Override
	public void checkName() {
		System.out.println("检查名字是否重复！");
	}
	
}
