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
 * 测试取不同区间的时间
 * @author Admain
 *
 */
public class TestSqlTime02 {
	//转换字符串到时间类型
	public  static long str2Date(String dateStr)
	{
		DateFormat formate=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formate.parse(dateStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("转化时间失败！！");
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
			System.out.println("加载类文件出错！！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("操作数据库异常！！");
		}
	}
}
