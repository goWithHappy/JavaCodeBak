import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 测试读取BLOB的读取
 * @author Admain
 *
 */
public class TestBlobReader {
	public static void main(String[] args) throws IOException {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		InputStream is=null;
		OutputStream os=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			ps=(PreparedStatement) conn.prepareStatement("select * from test_blob");
			rs=(ResultSet) ps.executeQuery();
			while(rs.next())
			{
				Blob b=rs.getBlob("file");
				//得到一个Blob
				is=b.getBinaryStream();
				int len=0;
				byte[] flush=new byte[1024];
				os=new BufferedOutputStream(new FileOutputStream(new File("F:/t.jpg")));
				while((len=is.read(flush))!=-1)
				{
					os.write(flush, 0, len);
					os.flush();
				}
				String s=new String(flush);
				System.out.println("图片转换为字符串为："+s);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载类异常！！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库加载异常！！");
		}
		finally {
			os.close();
			is.close();
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("resultSet关闭异常！！");
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("prepareStatement关闭异常！");
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Connection 关闭异常！！");
			}
			
		}
	}
}
