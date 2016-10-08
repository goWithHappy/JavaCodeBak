package between;

import java.util.List;

import core.Query;
import core.QueryFectory;
import core.TableContext;
import po.Pointinfo;

/**
 *�ṩ����������ݿ���ʵķ���
 * @author Admain
 *
 */
public class BackInfo {
	private static Query q=QueryFectory.createQuery();
	/**
	 * �������µ�һ����¼
	 * @param info
	 */
	public static void insert(String[] info){
		if(info!=null){
			Pointinfo point=new Pointinfo();
			point.setX(Double.parseDouble(info[0]));
			point.setY(Double.parseDouble(info[1]));
			point.setTime(new java.sql.Date(System.currentTimeMillis()));
			q.insert(point);
		}
	}
	/**
	 * �������ݿ������µ�һ�����ݿ��¼
	 * @return
	 */
	public static String getOneInfo(){
		String sql="select * from pointinfo order by id desc limit 0,10";
		Pointinfo point=(Pointinfo) q.queryUniqueRow(sql, Pointinfo.class, null);
		return point.getX()+","+point.getY();
	}
	/**
	 * �����ݿ��з���ָ�����������¼�¼
	 * @param index
	 * @return
	 */
	public static List<Pointinfo> getInfo(int index){
		String sql="select * from pointinfo order by id desc limit 0,"+index;
		List<Pointinfo> list=q.queryRows(sql, Pointinfo.class, null);
		return list;
	}
}