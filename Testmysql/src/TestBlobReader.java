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
 * ���Զ�ȡBLOB�Ķ�ȡ
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
				//�õ�һ��Blob
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
				System.out.println("ͼƬת��Ϊ�ַ���Ϊ��"+s);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�������쳣����");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ�����쳣����");
		}
		finally {
			os.close();
			is.close();
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("resultSet�ر��쳣����");
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("prepareStatement�ر��쳣��");
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Connection �ر��쳣����");
			}
			
		}
	}
}
