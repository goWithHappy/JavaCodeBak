package testORM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysqlUtils.MysqlUtil;

/**
 * 注意一定要面向接口进行编程
 * 使用Object来封装一条数据
 * @author Admain
 *
 */
public class Demo1 {
	public static void main(String[] args) throws SQLException {
		Connection conn=MysqlUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from emp");
		ResultSet rs=ps.executeQuery();
		//放到数组中可以进行再次使用
		Object source[]=new Object[3]; //使用Object来封装一条数据
		int i = 0,j=0;
		while(rs.next()){
//			System.out.println(rs.getString("empname"));
			source[i++]=rs.getString("empname");
		}
		MysqlUtil.close(conn, ps, rs);
		for(j=0;j<i;j++){
			System.out.println(source[j].toString());
		}
	}
}
