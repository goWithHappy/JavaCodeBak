package singleton;
/**
 * 通过枚举方式来实现单例模式
 * @author Admain
 *
 */
public enum EnumStyle {
	//则个枚举元素，本身就是一个单例模式,但是不能延时加载，可以天然防止反射和反序列化的漏洞
	instance;
	//添加自己所需要的操作
	public void operation(){
		System.out.println("操作单例对象");
	}
}
