package mysqlUtils;

/**
 * �����Լ���д��sqlUtils��
 * @author Admain
 *
 */
public class TestSqlUtils {
	public static void main(String[] args) {
		MysqlUtil util=new MysqlUtil();
		util.getConnection();
		System.out.println("���Գɹ���");
	}
}
