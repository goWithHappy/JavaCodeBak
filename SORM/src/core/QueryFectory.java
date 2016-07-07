package core;
/**
 * 根据配置信息返回Query对象的工厂类
 * @author Admain
 *
 */
public class QueryFectory {
	private QueryFectory(){}; //将QueryFactory进行对象私有化
	private static QueryFectory factory=new QueryFectory();
	private static Query protypeObj=null;
	static{
		//得到配置文件中对应的class类
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
			//初始化TableConext
			System.out.println(TableContext.class);
			//初始化DBManager
			System.out.println(DBManager.class);
	}
	
	/**
	 * 根据不同的配置信息创建不同的Query对象(通过克隆模式来进行快速获取)
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
