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
 * 管理数据库所有表结构和类结构的关系，并根据表结构生成类结构
 * @author Admain
 *
 */
public class TableContext {
	/**
	 * 表名为key，表信息为value
	 */
	public static Map<String,TableInfo> tables=new HashMap<>();
	/**
	 * 将po中的Class对象和表信息对象关联起来(便于以后操作)
	 */
	public static Map<Class,TableInfo> poClassTableMap=new HashMap<>();
	private TableContext(){}
	static{
		try {
			//初始化获得表的信息
			Connection conn=DBManager.getConnection();
			/**
			 * 获取数据库原信息的对象
			 */
			DatabaseMetaData dbmd=conn.getMetaData();
			ResultSet tableRet=dbmd.getTables(null, "%", "%", new String[]{"TABLE"});
			/**
			 * 获取所获得的表信息
			 */
			while(tableRet.next()){
				String tableName=(String) tableRet.getObject("TABLE_NAME");
				TableInfo ti=new TableInfo(tableName,new HashMap<String,ColumnInfo>(),new ArrayList<ColumnInfo>());
				tables.put(tableName, ti);
				
				ResultSet set=dbmd.getColumns(null, "%", tableName, "%"); //查询表中所有字段
				while(set.next()){
					/**
					 * 得到表中每一列的信息
					 */
					ColumnInfo ci=new ColumnInfo(set.getString("COLUMN_NAME"),
							set.getString("TYPE_NAME"),0);
					ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
				}
				
				ResultSet set2=dbmd.getPrimaryKeys(null, "%", tableName); //查询表中的主键
				while(set2.next()){
					ColumnInfo ci2=ti.getColumns().get(set2.getObject("COLUMN_NAME"));
					ci2.setKeyType(1); //设置为主键类型
					ti.getPriKey().add(ci2); //将主键信息添加到TableInfo里边
				}
				if(ti.getPriKey().size()>0){ //如果有多个主键则取唯一主键，如果是联合主键则为空
					ti.setOnlyPriKey(ti.getPriKey().get(0));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//更新类结构
		updateJavaPOFile();
		//将类与CLass对象进行关联
		loadPOTable();
	}
	public static Map<String,TableInfo> getTableInfos(){
		return tables;
	}
	/**
	 * 根据表结构，更新配置po包下边的java
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
