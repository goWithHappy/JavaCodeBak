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
 * ����jdbc��clob
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
			//ע����ʹ��clobʱһ��Ҫʹ�����Ӧ����������ʹ��setObjest����
//				ps.setObject(2, new FileReader(new File("F:/ceshi.txt")));
				ps.setClob(2,new FileReader(new File("f:/a.txt")));
//				ps.execute();
				ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("������������ִ��󣡣�");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�������ݿ��쳣����");
		}
	}
}
