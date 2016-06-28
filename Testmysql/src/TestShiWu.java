import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 测试事务的执行，了解事务执行的基本特点
 * @author Admain
 *
 */
public class TestShiWu {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			conn.setAutoCommit(false);
			ps1=(PreparedStatement) conn.prepareStatement("insert into user_table (id,name,password) values(5,?,'321')");
			ps1.setObject(1, "tom");
			ps1.execute();
			System.out.println("tom 插入成功！");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("休眠失败！");
			}
			ps2=(PreparedStatement) conn.prepareStatement("insert into user_table (id,name,password) values(6,?,?,?)");
			ps2.setObject(1, "jane");
			ps2.setObject(2, "111");
			System.out.println("jane插入成功！！");
			ps2.execute();
			conn.commit();
			//该方法用于使当前事务中的更改成为持久的更改，并释放Connection对象当前持有的所有数据库锁。此方法只有在手动事务的模式下才可以用。
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动类异常！！");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("与数据库连接异常！！");
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//				System.out.println("数据库回滚操作失败！");
//			}
		}
	}
}
