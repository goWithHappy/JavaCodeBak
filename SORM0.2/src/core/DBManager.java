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
 * 根据配置信息，维持连接对象的管理（增加连接池的功能）
 * @author Admain
 *
 */
import pool.DBConnectionPool;
public class DBManager {
	/**
	 * 配置信息
	 */
	private static Configuration conf;
	/**
	 * 连接池对象
	 */
	private static DBConnectionPool pool=null;
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
		conf.setQueryClass(pros.getProperty("queryClass"));
		conf.setPoolMaxSize(new Integer(Integer.parseInt(pros.getProperty("poolMaxSize"))));
		conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));
		
	}
	/**
	 * 获得Connection对象
	 * @return conn
	 */
	public static Connection getConnection()
	{
		if(pool==null){
			pool=new DBConnectionPool();
		}
		return pool.getConnection();
	}
	/**
	 * 仅仅供连接池使用的方法
	 * @return
	 */
	public static Connection createConnection(){
		try {
			Class.forName(conf.getDriver());
			//直接连接后期增加连接池处理，提高效率
			return (Connection) DriverManager.getConnection(conf.getUrl(),conf.getUser(),conf.getPwd());
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
	/**
	 * 关闭mysql所用类的方法
	 * @param conn
	 */
	public static void close(Connection conn)
	{
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("connection对象关闭失败！！");
//		}
		//通过连接池来进行connection对象的创建
		pool.close(conn);
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
	 * 对外提供Configuration
	 * @return Configuration
	 */
	public static Configuration getConf(){
		return conf;
	}
}
