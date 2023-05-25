package com.example.demo.pojo;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "person")
public class Person {
private String name;
private Integer age;
private List<String> lists;
private Integer id;
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
public List<String> getLists() {
	return lists;
}
public void setLists(List<String> lists) {
	this.lists = lists;
}
public Person(String name, Integer age, List<String> lists) {
	super();
	this.name = name;
	this.age = age;
	this.lists = lists;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Person() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Person [name=" + name + ", age=" + age + ", lists=" + lists + ", id=" + id + "]";
}



}
