import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 测试数据库中的时间类型
 * @author Admain
 *
 */
public class TestSqlTime {
	public static void main(String[] args) {
		Connection conn=null;
		Date date=new Date(System.currentTimeMillis());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement("insert into test_date (id,name,log_date,log_timestamp) values(?,?,?,?)");
			ps.setObject(1, 2);
			ps.setObject(2, "tom");
			ps.setObject(3, date);
			ps.setObject(4, new Timestamp(System.currentTimeMillis()));
			ps.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载类文件失败！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("操作数据库异常！！");
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("conn关闭失败！！");
			}
		}
	}
}
