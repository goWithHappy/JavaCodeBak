package pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.DBManager;

/**
 * 连接池
 * @author Admain
 *
 */
public class DBConnectionPool {
	private static List<Connection> pool; //连接池对象 
	/**
	 * 最大连接数
	 */
	private  final int POOL_MAX_SIZE=DBManager.getConf().getPoolMaxSize();
	private  final int POOL_MIN_SIZE=DBManager.getConf().getPoolMinSize();
	
	/**
	 * 初始化连接池
	 */
	private void initPool(){
		if(pool==null){
			pool=new ArrayList();
		}
		while(pool.size()<POOL_MIN_SIZE){
			pool.add(DBManager.createConnection());
			System.out.println("初始化连接池：池中连接数："+pool.size());
		}
	}
	public DBConnectionPool(){
		initPool();
	}
	/**
	 * 从连接池中获取一个Connection对象
	 * @return Connection
	 */
	public synchronized Connection getConnection(){
		int last_index=pool.size()-1;
		Connection conn=pool.get(last_index);
		pool.remove(last_index);
		return conn;
	}
	
	/**
	 * 关闭Connection对象（将连接放回到pool中）
	 * @param conn
	 */
	public void close(Connection conn){
		if(pool.size()>=POOL_MAX_SIZE){
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		pool.add(conn);
	}
}
