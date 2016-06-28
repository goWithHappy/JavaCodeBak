import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 测试从数据库中读取文本文件
 * @author Admain
 *
 */
public class TestClobReader {
	public static void main(String[] args) throws IOException {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			ps=(PreparedStatement) conn.prepareStatement("select * from test_clob where id=?");
			ps.setObject(1,2);
			rs=(ResultSet) ps.executeQuery();
			while(rs.next())
			{
				Clob cb=(Clob) rs.getClob("file");
				//由cb来返回一个字符流
				Reader reader=cb.getCharacterStream();
				int tempt=0;
				char[] b = new char[1024];
				while((tempt=reader.read(b))!=-1)
				{
					System.out.println(b);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动类异常！！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("操作数据库异常！！");
		}
	}
}
