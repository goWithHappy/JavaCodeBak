package singleton;
/**
 * ͨ��ö�ٷ�ʽ��ʵ�ֵ���ģʽ
 * @author Admain
 *
 */
public enum EnumStyle {
	//���ö��Ԫ�أ��������һ������ģʽ,���ǲ�����ʱ���أ�������Ȼ��ֹ����ͷ����л���©��
	instance;
	//����Լ�����Ҫ�Ĳ���
	public void operation(){
		System.out.println("������������");
	}
}
