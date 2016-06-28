package com.test;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//若注解只有一个参数值，一般将其设置为value,在使用时“value=”可以省略
@Target(value=ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface MyAnnotation02 {
	String value();
}
