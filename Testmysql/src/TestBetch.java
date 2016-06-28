import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * 测试批处理操作
 * @author Admain
 *
 */
public class TestBetch {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			String sql="insert into user_table (id,name,password) values(?,?,?);";  //注意？为占位符，可以防止sql注入式攻击
			//讲conn的自动提交设置为fals
			conn.setAutoCommit(false);
			Statement st=(Statement) conn.createStatement();
			for(int i=9;i<200;i++)
			{
				st.addBatch("delete from user_table where id="+i);
			}
			st.executeBatch();
			conn.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载类文件出错");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("连接数据库异常！！");
		}
	}
}
