package core;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import beans.Configuration;
/**
 * ����������Ϣ��ά�����Ӷ���Ĺ����������ӳصĹ��ܣ�
 * @author Admain
 *
 */
public class DBManager {
	private static Configuration conf;
	static {
		Properties pros =new Properties();
		try {
//			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			FileInputStream in = new FileInputStream("db.properties");
			pros.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		conf=new Configuration();
		conf.setDriver(pros.getProperty("driver"));
		conf.setPaPackage(pros.getProperty("paPackage"));
		conf.setPwd(pros.getProperty("pwd"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUser(pros.getProperty("user"));
		conf.setUsingDB(pros.getProperty("usingDB"));
	}
	/**
	 * ���Connection����
	 * @return
	 */
	public static Connection getConnection()
	{
		
		try {
			Class.forName(conf.getDriver());
			//ֱ�����Ӻ����������ӳش������Ч��
			return (Connection) DriverManager.getConnection(conf.getUrl(),conf.getUser(),conf.getPwd());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("���������������");
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʱ�����쳣����");
			return null;
		}
	}
	/**
	 * �ر�mysql������ķ���
	 * @param conn
	 */
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
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs)
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
	/**
	 * �����ṩConfiguration
	 * @return
	 */
	public static Configuration getConf(){
		return conf;
	}
}
