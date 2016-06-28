package com.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.activation.FileDataSource;

/**
 * ʹ�÷����ȡע����Ϣ��ģ�⴦����Ϣ������
 * @author Admain
 *
 */
public class ReadMessage {
	public static void main(String[] args) {
		try {
			Class clazz=Class.forName("com.test.Student");
			//��ȡ�����õ�ע��
			Annotation[] annotations=clazz.getAnnotations();
			for(Annotation annotation:annotations){
				System.out.println(annotation);
			}
			//������ָ��ע��
			Table table=(Table) clazz.getAnnotation(Table.class);
			System.out.println(table.value());
			
			//������Ե�ע��
			Field field=clazz.getDeclaredField("age");
			//ע����ʹ�õķ���
			TableField tableField=field.getAnnotation(TableField.class);
			System.out.println(tableField.colcumnName()+"--"+tableField.type()+"--"+tableField.length());
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
