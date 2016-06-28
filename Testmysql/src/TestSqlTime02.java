import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * ����ȡ��ͬ�����ʱ��
 * @author Admain
 *
 */
public class TestSqlTime02 {
	//ת���ַ�����ʱ������
	public  static long str2Date(String dateStr)
	{
		DateFormat formate=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formate.parse(dateStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("ת��ʱ��ʧ�ܣ���");
		}
		return 0;
	}
	public static void main(String[] args) {
		Connection conn;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","19950903a");
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement("select * from test_date where log_date=?");
			ps.setObject(1, new Date(str2Date("2015-10-25")));
			ResultSet rs=(ResultSet) ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+rs.getString(2)+rs.getDate(3));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�������ļ�������");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�������ݿ��쳣����");
		}
	}
}
