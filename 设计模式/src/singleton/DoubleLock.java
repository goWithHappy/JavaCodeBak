package singleton;

/**
 * ˫�ؼ����
 * ��ģʽ��ͬ���ӵ���if�������˵��õ�Ч�ʣ�����żȻ���������
 * @author Admain
 *
 */
public class DoubleLock {
	private  DoubleLock() {	}
	private static DoubleLock instance;
	public static DoubleLock getInstance(){
		//�������instance�Ƿ�Ϊnull
		if(instance==null){ //��һ�μ��
		synchronized (DoubleLock.class) {
			if(instance==null){
				instance=new DoubleLock();//�ڶ��μ��
			}
			}	
		}
		return instance;
	}
}
