package core;
/**
 * ����������Ϣ����Query����Ĺ�����
 * @author Admain
 *
 */
public class QueryFectory {
	private QueryFectory(){}; //��QueryFactory���ж���˽�л�
	private static QueryFectory factory=new QueryFectory();
	private static Query protypeObj=null;
	static{
		//�õ������ļ��ж�Ӧ��class��
			try {
				Class c=Class.forName(DBManager.getConf().getQueryClass());
				protypeObj=(Query) c.newInstance();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//��ʼ��TableConext
			System.out.println(TableContext.class);
			//��ʼ��DBManager
			System.out.println(DBManager.class);
	}
	
	/**
	 * ���ݲ�ͬ��������Ϣ������ͬ��Query����(ͨ����¡ģʽ�����п��ٻ�ȡ)
	 * @return
	 */
	public static Query createQuery(){
		try {
			return (Query) protypeObj.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
