import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

/**
 * ����muysql����
 * ע�⣺�����������л�ʹ�����ӳ�
 * @author Admain
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		try {
			long start=System.currentTimeMillis();
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			long end=System.currentTimeMillis();
//			System.out.println("������ʱ��"+(end-start));
//			System.out.println(conn);
			Statement stmt=(Statement) conn.createStatement();
			String name="'����'";
			String sql="DELETE FROM ceshi WHERE NAME="+name;
			stmt.execute(sql);
			System.out.println("�����ɹ�!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�����������ݿ����������");
		} catch (SQLException e) {
			System.out.println("�������ݿ��쳣����");
			e.printStackTrace();
		}
	}
}
