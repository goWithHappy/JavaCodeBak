package utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装了JDBC常见的操作
 * @author Admain
 *
 */
public class JDBCUtils {
	/* 为sql设置参数
	 * @param ps
	 * @param params
	 */
	public static void hanlerParams(PreparedStatement ps,Object[] params){
		//相当于为sql设置参数
		if(ps!=null){
			for(int i=0;i<params.length;i++){
				try {
					ps.setObject(i+1, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
