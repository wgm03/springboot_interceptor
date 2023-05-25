package com.example.demo.annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	private static final Pattern PHONE_PATTERN=java.util.regex.Pattern.compile(
			"^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$"
			);
	/*
	 * 校验的实现逻辑
	 * */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value==null || value.length()==0) {
			return true;
		}
		Matcher m=PHONE_PATTERN.matcher(value);
		return m.matches();
	}

}
