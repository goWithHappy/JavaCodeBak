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
 * ����servlet�������ݿ�����
 * @author Admain
 *
 */
public class TestRs extends HttpServlet{
	//��д�ͻ��˷��ʵ�ʵ����
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		//���÷��ظ��ͻ��˵��ı�����
		resp.setContentType("text/html");
		//�����ļ�����
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
			System.out.println("Class �쳣��");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�������Ӷ����쳣��");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
