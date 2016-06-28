import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 测试blob的使用以及其用法
 * @author Admain
 *
 */
public class TestBlob {
	public static void main(String[] args) throws FileNotFoundException {
		//加载驱动类
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			ps=(PreparedStatement) conn.prepareStatement("INSERT into test_blob (name,file) values('jane',?)");
			ps.setBlob(1, new FileInputStream(new File("f:/test.jpg")));
			ps.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动类加载异常!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库操作异常！！");
		}
	}
}
