package core;

<<<<<<< HEAD
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
>>>>>>> bug
import java.util.List;

import beans.ColumnInfo;
import beans.TableInfo;
import po.Emp;
import utils.JDBCUtils;
import utils.ReflectUtils;

/**
 * ���mysql���ݿ�Ĳ�ѯ
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
<<<<<<< HEAD
			System.out.println(ps);
			//��sql���ò���
			JDBCUtils.handleParams(ps, params);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
=======
			JDBCUtils.hanlerParams(ps, params);
			System.out.println(ps);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn,ps); 
		}
		
>>>>>>> bug
		return count;
	}

	@Override
<<<<<<< HEAD
	public void insert(Object obj) {
		//obj->insert into emp values(����������)
		Class c=obj.getClass();
		List<Object> params=new ArrayList<>();
		TableInfo tableInfo=TableContext.poClassTableMap.get(c);
		
		StringBuilder sql=new StringBuilder("insert into "+tableInfo.getTname()+" (");
		
		//������Ե�����
		Field[] fs=c.getDeclaredFields();
		int countNotNUll=0;
		for(Field f:fs){
			String fieldName=f.getName();
			Object fieldValue=ReflectUtils.invokeGet(fieldName, obj);
			
			//ֱ����ǿյ�����
			if(fieldValue!=null){
				sql.append(fieldName+",");
				countNotNUll++;
				params.add(fieldValue);
			}
		}
		sql.setCharAt(sql.length()-1, ')');
		sql.append(" values(");
		for(int i=0;i<countNotNUll;i++){
			sql.append("?,");
		}
			sql.setCharAt(sql.length()-1, ')');
			
			executeDML(sql.toString(), params.toArray());
=======
	public void insert(Object object) {
		// 
		
>>>>>>> bug
	}

	@Override
	public void delete(Class clazz, Object id) {
		// Emp.class,2-->delete from emp where id=2;
		//ͨ��Class������TableInfo
		TableInfo tableInfo=TableContext.poClassTableMap.get(clazz);
		ColumnInfo onlyPrimkey=tableInfo.getOnlyPriKey();
		
		//��ö�Ӧ��sql���
		String sql="delete from "+tableInfo.getTname()+" where "+onlyPrimkey.getName()+"=?";
		executeDML(sql, new Object[]{id});
	}

	@Override
	public void delete(Object obj) {
		// Obj->delete from emp where id=2;
		Class c=obj.getClass();
		TableInfo tableInfo=TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPrimaryKey=tableInfo.getOnlyPriKey();
		
		//ͨ��������ƣ�������Ӧset��get����
		Object priKeyValue=ReflectUtils.invokeGet(onlyPrimaryKey.getName(), obj);
		//���������ط���������ɾ��
		delete(c,priKeyValue);
		
	}

	@Override
	public int update(Object obj, String[] fileName) {
<<<<<<< HEAD
		//object {"uname","pwd"}-->update tname set username=?,=wd=? where id=?
		
=======
		// TODO Auto-generated method stub
>>>>>>> bug
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
<<<<<<< HEAD
	public static void main(String[] args) {
		Emp e=new Emp();
//		e.setId(4);
//		new MysqlQuery().delete(e);
		e.setAge(12);
		e.setBirthday(new java.sql.Date(System.currentTimeMillis()));
		e.setEmpname("����");
		e.setSalary((double) 1000);
		new MysqlQuery().insert(e);
=======
	/**
	 * ���Ե�main����
	 */
	public static void main(String[] args) {
		Emp e=new Emp();
		e.setId(3);
		
		new MysqlQuery().delete(e);
>>>>>>> bug
	}
}
