package testORM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysqlUtils.MysqlUtil;

/**
 * 将表结构和类进行一一对应，方便操作
 * @author Admain
 *
 */
public class Demo3 {
	public static void main(String[] args) throws SQLException {
		Connection conn=MysqlUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from emp");
		ResultSet rs=ps.executeQuery();
		//将所有记录放到list中
		List<Emp> list=new ArrayList<>();
		//将查询结果放到Emp对象中
		Emp emp=null;
//		Emp emp=new Emp();
		while(rs.next()){
			emp=new Emp();
			emp.setId(rs.getInt("id"));
			emp.setEmpname(rs.getString("empname"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setBirthday(rs.getString("birthday"));
			list.add(emp);
		}
		MysqlUtil.close(conn, ps, rs);
		for (Emp emp1 : list) {
			System.out.println("姓名："+emp1.getEmpname());
			System.out.println("薪水"+emp1.getSalary());
			System.out.println("出生日期"+emp1.getBirthday());
		}
			
		}


}
