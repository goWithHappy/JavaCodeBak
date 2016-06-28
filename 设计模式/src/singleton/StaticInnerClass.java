package singleton;

/**
 * ��̬�ڲ���ʵ�ַ�ʽ
 * @author Admain
 *
 */
public class StaticInnerClass {
	private StaticInnerClass(){}
	//�ڲ�����Ȼ�̰߳�ȫ��û��ͬ�������Ч�ʸ�
	private static class innerClass{
		private static final StaticInnerClass instance=new StaticInnerClass(); 
	}
	public static StaticInnerClass getInstance(){
		return innerClass.instance;
	}
}
