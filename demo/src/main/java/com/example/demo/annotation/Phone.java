package com.example.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
//@Documented：表示该注解会被包含在JavaDoc中。
@Constraint(validatedBy =PhoneValidator.class )
@Target({ElementType.METHOD,ElementType.FIELD})
//@Target({ElementType.METHOD,ElementType.FIELD})：表示该注解可以用于方法和字段上。
@Retention(RetentionPolicy.RUNTIME)
//@Retention(RetentionPolicy.RUNTIME)：表示该注解会在运行时保留，可以通过反射获取注解信息。
public @interface Phone {

	String message() default "请输入正确的电话号码"; 
	//表示校验不通过时的提示信息，默认为“请输入正确的电话号码”。
	Class<?>[] groups() default{}; //分组校验，只在新增时进行校验
	Class<? extends Payload>[] payload() default{};
	//Class<? extends Payload>[] payload() default{}：表示校验的负载，用于指定校验的程度。
	@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List{
		Phone[] value();
	}
}
