import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试servlet访问数据库连接
 * @author Admain
 *
 */
public class TestRs extends HttpServlet{
	//书写客户端访问的实体类
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		//设置返回给客户端的文本类型
		resp.setContentType("text/html");
		//设置文件编码
		resp.setCharacterEncoding("gb2312");
		PrintWriter out=resp.getWriter();
		out.println("<table border=1>");
		out.println("<tr><td>Content:</td></tr>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/bbs?user=root&password=19950903a");
			stmt=(Statement) conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Class 异常！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("创建连接对象异常！");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
