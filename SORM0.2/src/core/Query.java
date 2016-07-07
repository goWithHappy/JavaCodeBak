package core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ColumnInfo;
import beans.TableInfo;
import utils.JDBCUtils;
import utils.ReflectUtils;

/**
 * �����ѯ�������ṩ����ĺ����ࣩ
 * @author Admain
 *
 */
@SuppressWarnings("all")
public abstract class Query implements Cloneable{
	/**
	 * ������һ�����ڲ�ѯ��ģ��,�����Ժ������
	 * @param sql���
	 * @param params sql�Ĳ���
	 * @param clazz	��¼��װ��java��
	 * @param back Callback��ʵ�ֻص�
	 * @return
	 */
	public Object executeQueryTempt(String sql,Object[] params,Class clazz,CallBack back){
		Connection conn=DBManager.getConnection();
		List list=null; //�洢��ѯ���������
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			//��sql���ò���
			JDBCUtils.hanlerParams(ps, params);
			rs=ps.executeQuery();
			return back.doExecute(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	/**
	 * ִ��һ��DML���
	 * @param sql
	 * @param params
	 * @return ִ��sql���֮��Ӱ�������
	 */
	public int executeDML(String sql, Object[] params) {
		Connection conn=DBManager.getConnection();
		int count=0;
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			System.out.println(ps);
			//��sql���ò���
			JDBCUtils.hanlerParams(ps, params);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * ��һ������洢�����ݿ���
	 * @param object Ҫ�洢�Ķ���
	 */
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
	}
	/**
	 * ɾ��clazz��ʾ���Ӧ�ı��м�¼��ָ������ֵid�ļ�¼��
	 * @param clazz ������Ӧ��class����
	 * @param id
	 */
	public void delete(Class clazz, Object id) {
		// Emp.class,2-->delete from emp where id=2;
		//ͨ��Class������TableInfo
		TableInfo tableInfo=TableContext.poClassTableMap.get(clazz);
		ColumnInfo onlyPrimkey=tableInfo.getOnlyPriKey();
		
		//��ö�Ӧ��sql���
		String sql="delete from "+tableInfo.getTname()+" where "+onlyPrimkey.getName()+"=?";
		executeDML(sql, new Object[]{id});
	}
	/**
	 * ɾ�����������ݿ��еļ�¼���������ڵ��࣬�����������ֵ��Ӧ�ļ�¼��
	 * @param obj
	 */
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
	/**
	 * ���¶���ָ���ļ�¼������ֻ����ָ���ֶε�ֵ
	 * @param obj
	 * @param fileName
	 * @return
	 */
	public int update(Object obj, String[] fileName) {
		//object {"uname","pwd"}-->update tname set username=?,=wd=? where id=?
		Class c=obj.getClass();
		TableInfo tableInfo=TableContext.poClassTableMap.get(c);
		List<Object> params=new ArrayList<>();
		ColumnInfo onlyPrimaryKey=tableInfo.getOnlyPriKey();
		StringBuilder sql=new  StringBuilder("update "+tableInfo.getTname()+" set ");
		
		for(String fname:fileName){
			//�õ�valueֵ
			Object fvaue=ReflectUtils.invokeGet(fname, obj);
			params.add(fvaue);
			sql.append(fname+"=?,");
		}
		sql.setCharAt(sql.length()-1, ' ');
		sql.append(" where ");
		sql.append(onlyPrimaryKey.getName()+"=? ");
		//��id���Խ����滻
		params.add(ReflectUtils.invokeGet(onlyPrimaryKey.getName(), obj));
		return executeDML(sql.toString(), params.toArray()); 
	}
	/**
	 * ��ѯ���صĶ��м�¼������ÿ�м�¼��װ��clazzָ��������
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean��Class����
	 * @param params sql����
	 * @return ��ѯ���Ľ����
	 */
	public List queryRows(String sql, final Class clazz, Object[] params) {
		return (List) executeQueryTempt(sql, params, clazz, new CallBack() {
			
			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				List list=null;
				try {
					ResultSetMetaData rsmd=rs.getMetaData();
					//����
					while(rs.next()){
						if(list==null){
							list=new ArrayList();
						}
						Object rowObj=clazz.newInstance();  //����javaBean���޲ι�����
						//����
						for(int i=0;i<rsmd.getColumnCount();i++){
							String columnName=rsmd.getColumnLabel(i+1);
							Object columnValue=rs.getObject(i+1);
							//ͨ������������set�������������Ե�����
							ReflectUtils.invokeSet(rowObj, columnName, columnValue);
						}
						list.add(rowObj);
					}
				} catch (InstantiationException | IllegalAccessException | SQLException e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}
	/**
	 * ��ѯ����һ��һ��
	 * @param sql ��ѯ���
	 * @param params sql����
	 * @return ��ѯ���Ľ��
	 */
	public Object queryUniqueRow(String sql, Class clazz,Object[] params) {
		List list=queryRows(sql, clazz, params);
		//�����Ϊ���в�ѯ�������1�򷵻ص�һ��
		return (list!=null&&list.size()>0)?null:list.get(0);
	}
	/**
	 * ��ѯ����һ��һ�е�valueֵ���Ѿ�ȷ����ѯ�����һ�У�
	 * @param sql
	 * @param params
	 * @return
	 */
	public Number queryNumber(String sql, Object[] params) {
		return (Number)queryValue(sql, params);
	}
	/**
	 * ��ѯ����һ��һ��
	 * @param sql ��ѯ���
	 * @param params sql����
	 * @return ��ѯ��������
	 */
	public Object queryValue(String sql, Object[] params) {
		Connection conn=DBManager.getConnection();
		Object value=null; //��ѯ��Ψһ���ֵ
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			//��sql���ò���
			JDBCUtils.hanlerParams(ps, params);
			rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			//����
			while(rs.next()){
				value=rs.getObject(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return value;
	}
	/**
	 * ��ҳ��ѯ
	 * @param ��ѯҳ��
	 * @param ÿҳ��ʾ�ļ�¼����
	 * @return
	 */
	public abstract Object queryPagenate(int pageNum,int size);
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}