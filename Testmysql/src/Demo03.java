import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * ����prepareedStatement
 * @author Admain
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			String sql="insert into user_table (id,name,password) values(?,?,?);";  //ע�⣿Ϊռλ�������Է�ֹsqlע��ʽ����
			/**
			 * ע���ʺŴ�����ǲ��������ܼ����ŷ�������ʧ��
			 */
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);  //ע�������statement���˲���
			ps.setObject(1, 3);
			ps.setObject(2, "jane");
			ps.setObject(3, "123");
			System.out.println("������һ�м�¼����");
			ps.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�������ļ�����");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�������ݿ��쳣����");
		}
	}
}
