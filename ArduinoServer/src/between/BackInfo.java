package between;

import java.util.List;

import core.Query;
import core.QueryFectory;
import core.TableContext;
import po.Pointinfo;

/**
 *提供对外进行数据库访问的方法
 * @author Admain
 *
 */
public class BackInfo {
	private static Query q=QueryFectory.createQuery();
	/**
	 * 插入最新的一条记录
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
	 * 返回数据库中最新的一条数据库记录
	 * @return
	 */
	public static String getOneInfo(){
		String sql="select * from pointinfo order by id desc limit 0,10";
		Pointinfo point=(Pointinfo) q.queryUniqueRow(sql, Pointinfo.class, null);
		return point.getX()+","+point.getY();
	}
	/**
	 * 从数据库中返回指定条数的最新记录
	 * @param index
	 * @return
	 */
	public static List getInfo(int index){
		String sql="select * from pointinfo order by id desc limit 0,"+index;
		List list=q.queryRows(sql, Pointinfo.class, null);
		return list;
	}
}
