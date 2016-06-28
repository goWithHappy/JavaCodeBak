package com.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.activation.FileDataSource;

/**
 * 使用反射读取注解信息，模拟处理信息的流程
 * @author Admain
 *
 */
public class ReadMessage {
	public static void main(String[] args) {
		try {
			Class clazz=Class.forName("com.test.Student");
			//获取类所用的注解
			Annotation[] annotations=clazz.getAnnotations();
			for(Annotation annotation:annotations){
				System.out.println(annotation);
			}
			//获得类的指定注解
			Table table=(Table) clazz.getAnnotation(Table.class);
			System.out.println(table.value());
			
			//获得属性的注解
			Field field=clazz.getDeclaredField("age");
			//注意所使用的方法
			TableField tableField=field.getAnnotation(TableField.class);
			System.out.println(tableField.colcumnName()+"--"+tableField.type()+"--"+tableField.length());
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
