import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * �������������
 * @author Admain
 *
 */
public class TestBetch {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			String sql="insert into user_table (id,name,password) values(?,?,?);";  //ע�⣿Ϊռλ�������Է�ֹsqlע��ʽ����
			//��conn���Զ��ύ����Ϊfals
			conn.setAutoCommit(false);
			Statement st=(Statement) conn.createStatement();
			for(int i=9;i<200;i++)
			{
				st.addBatch("delete from user_table where id="+i);
			}
			st.executeBatch();
			conn.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�������ļ�����");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�������ݿ��쳣����");
		}
	}
}
