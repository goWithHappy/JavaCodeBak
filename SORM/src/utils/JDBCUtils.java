package utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装了JDBC常见的操作
 * @author Admain
 *
 */
public class JDBCUtils {
	/**
	 * 为preparestatement传递参数
	 * @param ps
	 * @param params
	 */
	public static void handleParams(PreparedStatement ps,Object[] params){
		if(params!=null){
			for(int i=0;i<params.length;i++){
				try {
					ps.setObject(1+i, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
