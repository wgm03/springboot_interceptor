package com.example.demo.pojo;

public class Student {
	private String username;
	private String password;
	public Student(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
