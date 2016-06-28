package com.test;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.FIELD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface TableField {
	String colcumnName();
	String type();
	int length();
}
