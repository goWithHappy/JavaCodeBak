package testORM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysqlUtils.MysqlUtil;

/**
 * ע��һ��Ҫ����ӿڽ��б��
 * ʹ��Object����װһ������
 * @author Admain
 *
 */
public class Demo1 {
	public static void main(String[] args) throws SQLException {
		Connection conn=MysqlUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from emp");
		ResultSet rs=ps.executeQuery();
		//�ŵ������п��Խ����ٴ�ʹ��
		Object source[]=new Object[3]; //ʹ��Object����װһ������
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
