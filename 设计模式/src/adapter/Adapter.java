package adapter;
/**
 * 使目标与被适配对象联系起来的方法：
 * 1.继承被适配对象，实现接口
 * 2.通过对象的组合可以来实现
 * @author Admain
 *
 */
public class Adapter extends Adaptee implements Target{

	@Override
	public void handleReq() {
		// TODO Auto-generated method stub
		super.request();
	}

}
