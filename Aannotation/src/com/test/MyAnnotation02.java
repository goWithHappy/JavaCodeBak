package com.test;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//��ע��ֻ��һ������ֵ��һ�㽫������Ϊvalue,��ʹ��ʱ��value=������ʡ��
@Target(value=ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface MyAnnotation02 {
	String value();
}
