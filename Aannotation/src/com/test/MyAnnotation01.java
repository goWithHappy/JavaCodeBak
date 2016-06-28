package com.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface MyAnnotation01 {
	String studentAge();   //���û��Ĭ��ֵ������ʹ�ø�ע��ʱһ��Ҫ�������
	String studentName() default ""; //��ʹ��ע��ʱ���û�д����������Ĭ�ϸ��ò�����ֵΪ����
	String[] school() default {"nepu"};   //Ҳ����ʹ�����飬������Ĭ��ֵʱ��һ��Ҫ��{}
}
