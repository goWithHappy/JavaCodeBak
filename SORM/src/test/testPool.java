package test;

import java.util.List;

import core.Query;
import core.QueryFectory;
import po.Emp;

/**
 * �������ӳصĵ���
 * @author Admain
 *
 */
public class testPool {
	public static void main(String[] args) {
		test01();
	}
	public static void test01(){
		Query q=QueryFectory.createQuery();
		//��ѯ����
		List<Emp>list=q.queryRows("select id,empname,age from emp where age<? and salary<?", Emp.class, new Object []{100,5000});
		for(Emp e1:list){
			System.out.println(e1.getEmpname());
		}
	}
}