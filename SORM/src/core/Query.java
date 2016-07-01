package core;

import java.util.List;

/**
 * �����ѯ�������ṩ����ĺ����ࣩ
 * @author Admain
 *
 */
@SuppressWarnings("all")
public interface Query {
	/**
	 * ִ��һ��DML���
	 * @param sql
	 * @param params
	 * @return ִ��sql���֮��Ӱ�������
	 */
	public int executeDML(String sql,Object[] params);
	/**
	 * ��һ������洢�����ݿ���
	 * @param object Ҫ�洢�Ķ���
	 */
	public void insert(Object object);
	/**
	 * ɾ��clazz��ʾ���Ӧ�ı��м�¼��ָ������ֵid�ļ�¼��
	 * @param clazz ������Ӧ��class����
	 * @param id
	 */
	public void delete(Class clazz,int id); //delete from user where id=?
	/**
	 * ɾ�����������ݿ��еļ�¼���������ڵ��࣬�����������ֵ��Ӧ�ļ�¼��
	 * @param obj
	 */
	public void delete(Object obj);
	/**
	 * ���¶���ָ���ļ�¼������ֻ����ָ���ֶε�ֵ
	 * @param obj
	 * @param fileName
	 * @return
	 */
	public int update(Object obj,String[] fileName);//update user set uname=?,pwd=?
	/**
	 * ��ѯ���صĶ��м�¼������ÿ�м�¼��װ��clazzָ��������
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean��Class����
	 * @param params sql����
	 * @return ��ѯ���Ľ����
	 */
	public List queryRows(String sql,Class clazz,Object[] params);
	/**
	 * ��ѯ����һ��һ��
	 * @param sql ��ѯ���
	 * @param params sql����
	 * @return ��ѯ���Ľ��
	 */
	public Object queryUniqueRow(String sql,Object[] params);
	/**
	 * ��ѯ����һ��һ��
	 * @param sql ��ѯ���
	 * @param params sql����
	 * @return ��ѯ��������
	 */
	public Number queryNumber(String sql,Object[] params);
}