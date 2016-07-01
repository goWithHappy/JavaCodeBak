
package mysqlUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ��дmysql�Ĺ�����
 * @author Admain
 *
 */
public class MysqlUtil {
	/**
	 * ͨ����̬����������������Ҫ���ļ�
	 * @return
	 */
	private static Properties pros=null;  //�������Ǵ�����Դ�ļ�������Ϣ
	static{
		try {
			pros=new Properties();
//			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			FileInputStream in = new FileInputStream("db.properties");
			pros.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�����ļ�����ʱ������");
		}
	}
	//���Connection����
	public static Connection getConnection()
	{
		
		try {
			Class.forName(pros.getProperty("mysqlDriver"));
			return (Connection) DriverManager.getConnection(pros.getProperty("mysqlURL"),pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�����������������");
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʱ�����쳣����");
			return null;
		}
	}
	//�ر�mysql������ķ���
	public static void close(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connection����ر�ʧ�ܣ���");
		}
	}
	public static void close(PreparedStatement ps)
	{
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("prepareStatement�ر��쳣����");
		}
	}
	public static void close(Statement statement)
	{
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Statement �ر��쳣����");
		}
	}
	public static void close(ResultSet rs)
	{
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ResultSet����ر��쳣!");
		}
	}
	public static void close(Connection conn,PreparedStatement ps)
	{
		close(conn);
		close(ps);
	}
	public static void close(Connection conn,java.sql.PreparedStatement ps,ResultSet rs)
	{
		close(rs);
		close(ps);
		close(conn);
	}
	public static void close(Connection conn,Statement statement)
	{
		close(statement);
		close(conn);
	}
	public static void close(Connection conn,Statement statement,ResultSet rs)
	{
		close(rs);
		close(statement);
		close(conn);
	}
}