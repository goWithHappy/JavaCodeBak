package FianlSever;

/**
 * servlet用来应对客户端响应
 * 不存储Servlet对象只是存储其完整路径，在需要对象时动态创建
 * @author Admain
 *
 */
public abstract class Servlet {
	public void service(Request req,Response rep){
		/*
		 * 增加这两个函数会造成结果的二次打印
		 */
		this.doPost(req,rep);
//		this.doGet(req,rep);
	}
	public abstract void doGet(Request req,Response rep);
	public abstract void doPost(Request req,Response rep);
}
