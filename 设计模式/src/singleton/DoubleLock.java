package singleton;

/**
 * 双重检测锁
 * 该模式将同步加到了if后边提高了调用的效率，但是偶然会出现问题
 * @author Admain
 *
 */
public class DoubleLock {
	private  DoubleLock() {	}
	private static DoubleLock instance;
	public static DoubleLock getInstance(){
		//检测两次instance是否为null
		if(instance==null){ //第一次检查
		synchronized (DoubleLock.class) {
			if(instance==null){
				instance=new DoubleLock();//第二次检查
			}
			}	
		}
		return instance;
	}
}
