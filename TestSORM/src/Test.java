import java.util.List;

import core.Query;
import core.QueryFectory;
import po.Emp;

public class Test {
	public static void main(String[] args) {
//		//通过方法生成po类
//		TableContext.updateJavaPOFile();
		//通过SORM来进行插入操作
		testSelect();
	}
	public static void testDelete(){
		Emp e=new Emp();
		e.setId(5);
		Query q=QueryFectory.createQuery();
	}
	public static void testInsert(){
		Emp e=new Emp();
		e.setAge(18);
		e.setBirthday(new java.sql.Date(System.currentTimeMillis()));
		e.setEmpname("Tom");
		Query q=QueryFectory.createQuery();
		q.insert(e);
	}
	public static void testUpdate(){
		Emp e=new Emp();
		e.setAge(15);
		e.setId(5);
		e.setSalary(100.0);
		Query q=QueryFectory.createQuery();
		q.update(e, new String[]{"age","salary"});
	}
	public static void testSelect(){
		//查询多行
		Query q=QueryFectory.createQuery();
		List<Emp>list=q.queryRows("select id,empname,age from emp where age<? and salary<?", Emp.class, new Object []{100,5000});
		for(Emp e1:list){
			System.out.println(e1.getEmpname());
		}
	}
}
