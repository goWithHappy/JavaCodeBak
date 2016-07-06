package core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.UpdatableResultSet;

import beans.ColumnInfo;
import beans.TableInfo;
import utils.JavaFileUtils;
import utils.StringUtils;

/**
 * �������ݿ����б�ṹ����ṹ�Ĺ�ϵ�������ݱ�ṹ������ṹ
 * @author Admain
 *
 */
public class TableContext {
	/**
	 * ����Ϊkey������ϢΪvalue
	 */
	public static Map<String,TableInfo> tables=new HashMap<>();
	/**
	 * ��po�е�Class����ͱ���Ϣ�����������(�����Ժ����)
	 */
	public static Map<Class,TableInfo> poClassTableMap=new HashMap<>();
	private TableContext(){}
	static{
		try {
			//��ʼ����ñ����Ϣ
			Connection conn=DBManager.getConnection();
			/**
			 * ��ȡ���ݿ�ԭ��Ϣ�Ķ���
			 */
			DatabaseMetaData dbmd=conn.getMetaData();
			ResultSet tableRet=dbmd.getTables(null, "%", "%", new String[]{"TABLE"});
			/**
			 * ��ȡ����õı���Ϣ
			 */
			while(tableRet.next()){
				String tableName=(String) tableRet.getObject("TABLE_NAME");
				TableInfo ti=new TableInfo(tableName,new HashMap<String,ColumnInfo>(),new ArrayList<ColumnInfo>());
				tables.put(tableName, ti);
				
				ResultSet set=dbmd.getColumns(null, "%", tableName, "%"); //��ѯ���������ֶ�
				while(set.next()){
					/**
					 * �õ�����ÿһ�е���Ϣ
					 */
					ColumnInfo ci=new ColumnInfo(set.getString("COLUMN_NAME"),
							set.getString("TYPE_NAME"),0);
					ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
				}
				
				ResultSet set2=dbmd.getPrimaryKeys(null, "%", tableName); //��ѯ���е�����
				while(set2.next()){
					ColumnInfo ci2=ti.getColumns().get(set2.getObject("COLUMN_NAME"));
					ci2.setKeyType(1); //����Ϊ��������
					ti.getPriKey().add(ci2); //��������Ϣ��ӵ�TableInfo���
				}
				if(ti.getPriKey().size()>0){ //����ж��������ȡΨһ���������������������Ϊ��
					ti.setOnlyPriKey(ti.getPriKey().get(0));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//������ṹ
		updateJavaPOFile();
		//������CLass������й���
		loadPOTable();
	}
	public static Map<String,TableInfo> getTableInfos(){
		return tables;
	}
	/**
	 * ���ݱ�ṹ����������po���±ߵ�java
	 * @return 
	 */
	public static void updateJavaPOFile(){
		Map<String,TableInfo> map=TableContext.tables;
		for(TableInfo tableInfo:map.values()){
			JavaFileUtils.createJavaaPOFile(tableInfo, new MysqlTypeConvertor());
		}
	}
	
	public static void loadPOTable(){
		for(TableInfo tableInfo:tables.values()){
			try {
				Class c=Class.forName(DBManager.getConf().getPaPackage()
						+"."+StringUtils.firstChar2UpperCase(tableInfo.getTname()));
				poClassTableMap.put(c, tableInfo);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	public static void main(String[] args) {
		Map<String,TableInfo> tables=TableContext.tables;
		System.out.println(tables);
	}
}
