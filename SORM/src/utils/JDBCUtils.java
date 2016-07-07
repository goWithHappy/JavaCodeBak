package utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ��װ��JDBC�����Ĳ���
 * @author Admain
 *
 */
public class JDBCUtils {
	/**
	 * Ϊpreparestatement���ݲ���
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
