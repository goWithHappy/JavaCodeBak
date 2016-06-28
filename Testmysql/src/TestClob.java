import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 测试jdbc中clob
 * @author Admain
 *
 */
public class TestClob {
	public static void main(String[] args) throws FileNotFoundException{
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			ps=(PreparedStatement) conn.prepareStatement("insert into test_clob (name,file) values(?,?)");
			ps.setString(1, "Tom");
			//注意在使用clob时一定要使用其对应方法不能再使用setObjest方法
//				ps.setObject(2, new FileReader(new File("F:/ceshi.txt")));
				ps.setClob(2,new FileReader(new File("f:/a.txt")));
//				ps.execute();
				ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动类出现错误！！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("操作数据库异常！！");
		}
	}
}
