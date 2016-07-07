package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import beans.ColumnInfo;
import beans.TableInfo;
import po.Emp;
import utils.JDBCUtils;
import utils.ReflectUtils;

/**
 * 针对mysql数据库的查询
 * @author Admain
 *
 */
public class MysqlQuery implements Query{

	@Override
	public int executeDML(String sql, Object[] params) {
		Connection conn=DBManager.getConnection();
		int count=0;
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			JDBCUtils.hanlerParams(ps, params);
			System.out.println(ps);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn,ps); 
		}
		
		return count;
	}

	@Override
	public void insert(Object object) {
		// 
		
	}

	@Override
	public void delete(Class clazz, Object id) {
		// Emp.class,2-->delete from emp where id=2;
		//通过Class对象找TableInfo
		TableInfo tableInfo=TableContext.poClassTableMap.get(clazz);
		ColumnInfo onlyPrimkey=tableInfo.getOnlyPriKey();
		
		//获得对应的sql语句
		String sql="delete from "+tableInfo.getTname()+" where "+onlyPrimkey.getName()+"=?";
		executeDML(sql, new Object[]{id});
	}

	@Override
	public void delete(Object obj) {
		// Obj->delete from emp where id=2;
		Class c=obj.getClass();
		TableInfo tableInfo=TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPrimaryKey=tableInfo.getOnlyPriKey();
		
		//通过反射机制，调用响应set和get方法
		Object priKeyValue=ReflectUtils.invokeGet(onlyPrimaryKey.getName(), obj);
		//调用其重载方法来进行删除
		delete(c,priKeyValue);
		
	}

	@Override
	public int update(Object obj, String[] fileName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List queryRows(String sql, Class clazz, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object queryUniqueRow(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number queryNumber(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 测试的main方法
	 */
	public static void main(String[] args) {
		Emp e=new Emp();
		e.setId(3);
		
		new MysqlQuery().delete(e);
	}
}
