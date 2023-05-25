package com.example.demo.pojo;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import com.example.demo.annotation.Phone;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
@SuppressWarnings("deprecation")
@Component
public class User {
   @NotBlank(message = "姓名不能为空")
   @Length(min=2,max = 10,message = "姓名长度错误，姓名长度2-10！")
	private String name;
   @NotNull(message = "年龄不能为空！")
   @Min(18)
   private Integer age;
   
   @NotBlank(message = "地址不能为空")
   private String address;
   @Phone
   private String phone;
   @Email(message = "邮箱格式错误！")
   private String email;
public User(@NotBlank(message = "姓名不能为空") @Length(min = 2, max = 10, message = "姓名长度错误，姓名长度2-10！") String name,
		@NotNull(message = "年龄不能为空！") @Min(18) Integer age, @NotBlank(message = "地址不能为空") String address,
		@Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|19[8|9])\\d{8}$", message = "手机号格式错误") String phone,
		@Email(message = "邮箱格式错误！") String email) {
	super();
	this.name = name;
	this.age = age;
	this.address = address;
	this.phone = phone;
	this.email = email;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

   
}
