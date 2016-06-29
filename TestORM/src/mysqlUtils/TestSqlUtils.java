package mysqlUtils;

/**
 * 测试自己编写的sqlUtils类
 * @author Admain
 *
 */
public class TestSqlUtils {
	public static void main(String[] args) {
		MysqlUtil util=new MysqlUtil();
		util.getConnection();
		System.out.println("测试成功！");
	}
}
