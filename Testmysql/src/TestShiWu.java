import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * ���������ִ�У��˽�����ִ�еĻ����ص�
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
			System.out.println("tom ����ɹ���");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("����ʧ�ܣ�");
			}
			ps2=(PreparedStatement) conn.prepareStatement("insert into user_table (id,name,password) values(6,?,?,?)");
			ps2.setObject(1, "jane");
			ps2.setObject(2, "111");
			System.out.println("jane����ɹ�����");
			ps2.execute();
			conn.commit();
			//�÷�������ʹ��ǰ�����еĸ��ĳ�Ϊ�־õĸ��ģ����ͷ�Connection����ǰ���е��������ݿ������˷���ֻ�����ֶ������ģʽ�²ſ����á�
		} catch (ClassNotFoundException e) {
			System.out.println("�����������쳣����");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�����ݿ������쳣����");
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//				System.out.println("���ݿ�ع�����ʧ�ܣ�");
//			}
		}
	}
}
