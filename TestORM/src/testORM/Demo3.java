package testORM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysqlUtils.MysqlUtil;

/**
 * ����ṹ�������һһ��Ӧ���������
 * @author Admain
 *
 */
public class Demo3 {
	public static void main(String[] args) throws SQLException {
		Connection conn=MysqlUtil.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from emp");
		ResultSet rs=ps.executeQuery();
		//�����м�¼�ŵ�list��
		List<Emp> list=new ArrayList<>();
		//����ѯ����ŵ�Emp������
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
			System.out.println("������"+emp1.getEmpname());
			System.out.println("нˮ"+emp1.getSalary());
			System.out.println("��������"+emp1.getBirthday());
		}
			
		}


}
