import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 测试prepareedStatement
 * @author Admain
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			String sql="insert into user_table (id,name,password) values(?,?,?);";  //注意？为占位符，可以防止sql注入式攻击
			/**
			 * 注意问号代表的是参数，不能加引号否则会造成失败
			 */
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);  //注意其相比statement多了参数
			ps.setObject(1, 3);
			ps.setObject(2, "jane");
			ps.setObject(3, "123");
			System.out.println("插入了一行记录！！");
			ps.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载类文件出错");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("连接数据库异常！！");
		}
	}
}
