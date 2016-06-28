import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 进行查询操作测试
 * @author Admain
 *
 */
public class Demo4 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rSet=null;
		//加载驱动类
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			String sql="select * from user_table where id=?";
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setObject(1, 1);
			rSet=(ResultSet) ps.executeQuery();
			while(rSet.next())
			{
				System.out.println(rSet.getInt("id")+rSet.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动类异常！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接异常！");
		}
		finally {
			//注意后打开的要先关闭
				try {
					rSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("关闭resultSet时出现异常！！");
				}
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("关闭prepareStatement时出现异常！！");
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("关闭connection对象时出现异常！！");
				}
			
		}
		
	}
}
