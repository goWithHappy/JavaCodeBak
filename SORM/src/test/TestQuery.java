package test;

import java.util.List;

import core.MysqlQuery;
import core.Query;
import core.QueryFectory;
import po.Emp;

public class TestQuery {
	public static void main(String[] args) {
		Query q=QueryFectory.createQuery();
		//≤È—Ø∂‡––
		List<Emp>list=q.queryRows("select id,empname,age from emp where age<? and salary<?", Emp.class, new Object []{100,5000});
		for(Emp e1:list){
			System.out.println(e1.getEmpname());
		}
	}
}
