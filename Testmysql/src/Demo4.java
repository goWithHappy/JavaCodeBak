import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * ���в�ѯ��������
 * @author Admain
 *
 */
public class Demo4 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rSet=null;
		//����������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			String sql="select * from user_table where id=?";
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setObject(1, 1);
			rSet=(ResultSet) ps.executeQuery();
			while(rSet.next())
			{
				System.out.println(rSet.getInt("id")+rSet.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�����������쳣��");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ������쳣��");
		}
		finally {
			//ע���򿪵�Ҫ�ȹر�
				try {
					rSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("�ر�resultSetʱ�����쳣����");
				}
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("�ر�prepareStatementʱ�����쳣����");
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("�ر�connection����ʱ�����쳣����");
				}
			
		}
		
	}
}
