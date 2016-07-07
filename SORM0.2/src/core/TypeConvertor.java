package core;
/**
 * ����java�������ͺ����ݿ����͵��໥ת��
 * @author Admain
 *
 */
public interface TypeConvertor {
	/**
	 * �����ݿ�����ת��Ϊjava���ݿ�����
	 * @param columnType ���ݿ��ֶε���������
	 * @return java����������
	 */
	public String databaseType2JavaType(String columnType);
	/**
	 * ����java����ת��Ϊ���ݿ�����
	 * @param javaDataType java��������
	 * @return ���ݿ�����
	 */
	public String javaType2DatabaseType(String javaDataType);
}
