package com.example.demo;



import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.Person;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.User;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Controller
@Validated
public class SpringTest {
     @Autowired
	private Person person;
	@RequestMapping(value = "/first/{id}",method = RequestMethod.GET)
	public String hello(Model model) {
			System.out.println("当前Model:"+model.containsAttribute("integer"));
		return "index";
	}
	/*
	 * @ModelAttribute public Integer getUsername(@PathVariable("id") Integer id) {
	 * return id; }
	 */
	
	@RequestMapping(value = "/user/msg",method = RequestMethod.POST)
	@ResponseBody
	public String user(Student student,Model model) {
		String username=student.getUsername();
		String password=student.getPassword();
		System.out.println(username+password);
		return "成功";
		
	}
	//JavaBean参数校验
	@PostMapping(path = "/check")
	@ResponseBody
	public String check(@RequestBody @Valid User user,BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> list=result.getAllErrors();
			for(ObjectError error: list) {
				System.out.println(error.getCode()+"-"+error.getDefaultMessage());
			}
		}
		System.out.println("controller....");
		return "lisi";
	}
	//URL参数校验
	@RequestMapping("/query")
	@ResponseBody
	public String query(@Length(min = 2,max =10,message = "姓名长度错误姓名长度2-10") 
	                    @RequestParam(name = "name",required = true) String name,
	                    @Min(value=1,message="年龄最小为1")
	                    @Max(value = 99,message = "年龄最大为99")
	                    @RequestParam(name = "age",required = true)
	                    int age) {
		System.out.println(name+","+age);
		return name+","+age;
	}

}
