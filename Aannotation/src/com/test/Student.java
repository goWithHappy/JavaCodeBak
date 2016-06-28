package com.test;


@Table("tb_student")
public class Student {
	@TableField(colcumnName="id",type="int",length=10)
	private int id;
	@TableField(colcumnName="studentName",type="varchar",length=10)
	private int studentName;
	@TableField(colcumnName="age",type="int",length=3)
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentName() {
		return studentName;
	}
	public void setStudentName(int studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
