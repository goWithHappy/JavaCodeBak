package factor.simplefactory;

/**
 * �����й�����ʵ��
 * @author Admain
 *
 */
public class CreateCar {
	/**
	 * ʵ�ַ�ʽ1ͨ������������жϳ�������
	 * @param type
	 * @return
	 */
	public Car createCar(String type){
		if("�µ�".equals(type)) return new AoDi();
		else if("���ǵ�".equals(type)) return new Byd();
		else return null;
	}
	/**
	 * ͨ����ͬ�ľ�̬�������õ���ͬ�ĳ�
	 */
	public static Car getByd(){
		return new Byd();
	}
	public static Car getAodi(){
		return new AoDi();
	}
}
