package testORM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mysqlUtils.MysqlUtil;
/**
 * 使用Map进行结果的封装
 * @author Admain
 *
 */
public class Demo2 {
	public static void main(String[] args) throws SQLException {
		Connection conn=MysqlUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from emp");
		ResultSet rs=ps.executeQuery();
		Map<String,Object> map=new HashMap<>(); 
		List<Map> source=new ArrayList<Map>();
		while(rs.next()){
			map.put("empname", rs.getObject(1));
			map.put("salary", rs.getObject(2));
			map.put("age", rs.getObject(3));
			source.add(map);
		}
		MysqlUtil.close(conn, ps, rs);
		for (Map list : source) {
			map=list;
			for (String key : map.keySet()) {
				System.out.println("key"+"--"+map.get(key)+"\t");
			}
		}
	}


}
