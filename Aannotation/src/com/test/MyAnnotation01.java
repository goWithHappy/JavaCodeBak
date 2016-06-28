package com.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface MyAnnotation01 {
	String studentAge();   //如果没有默认值，则在使用该注解时一定要传入参数
	String studentName() default ""; //在使用注解时如果没有传入参数，则默认给该参数赋值为“”
	String[] school() default {"nepu"};   //也可以使用数组，但设置默认值时，一定要用{}
}
