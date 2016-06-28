package singleton;

import java.io.Serializable;

/**
 * ����ʽ
 * @author Admain
 *
 */
public class LazyStyle implements Serializable{
	//���ʼ��ʱ������ʼ�����������������õ�ʱ���ٽ��г�ʼ��
	private static LazyStyle instance;
	private LazyStyle() {
		if(instance!=null){
			throw new RuntimeException();
		}
	}
	//��ͬ������飬���̵߳���ʱЧ�ʱȽϵ�
	public static synchronized LazyStyle getInstance(){
		if(instance==null){
			instance=new LazyStyle();
		}
		return instance;
	}
	//��ֹͨ�������л���ʽ�������ƽ�
	private Object readResolve(){
		return instance;
	}
}
