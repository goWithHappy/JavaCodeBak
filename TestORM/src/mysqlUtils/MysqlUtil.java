
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
 * 书写mysql的工具类
 * @author Admain
 *
 */
public class MysqlUtil {
	/**
	 * 通过静态块来加载驱动所需要的文件
	 * @return
	 */
	private static Properties pros=null;  //帮助我们处理资源文件配置信息
	static{
		try {
			pros=new Properties();
//			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			FileInputStream in = new FileInputStream("db.properties");
			pros.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("配置文件加载时出错！");
		}
	}
	//获得Connection对象
	public static Connection getConnection()
	{
		
		try {
			Class.forName(pros.getProperty("mysqlDriver"));
			return (Connection) DriverManager.getConnection(pros.getProperty("mysqlURL"),pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动类出错！！");
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("连接数据库时出现异常！！");
			return null;
		}
	}
	//关闭mysql所用类的方法
	public static void close(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connection对象关闭失败！！");
		}
	}
	public static void close(PreparedStatement ps)
	{
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("prepareStatement关闭异常！！");
		}
	}
	public static void close(Statement statement)
	{
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Statement 关闭异常！！");
		}
	}
	public static void close(ResultSet rs)
	{
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ResultSet对象关闭异常!");
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
