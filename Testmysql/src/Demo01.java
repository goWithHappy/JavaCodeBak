import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

/**
 * 测试muysql连接
 * 注意：在真正开发中会使用连接池
 * @author Admain
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		try {
			long start=System.currentTimeMillis();
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			long end=System.currentTimeMillis();
//			System.out.println("连接用时："+(end-start));
//			System.out.println(conn);
			Statement stmt=(Statement) conn.createStatement();
			String name="'李明'";
			String sql="DELETE FROM ceshi WHERE NAME="+name;
			stmt.execute(sql);
			System.out.println("操作成功!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("记载连接数据库的驱动错误！");
		} catch (SQLException e) {
			System.out.println("连接数据库异常！！");
			e.printStackTrace();
		}
	}
}
