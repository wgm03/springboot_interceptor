package com.example.demo.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.HandlerInterceptor;

@Configuration
public class FilterBean implements WebMvcConfigurer {
	  @Autowired 
	  private UserFilter filter1;
	 @Bean public FilterRegistrationBean<UserFilter> filter() {
	  FilterRegistrationBean<UserFilter> registration = new
	  FilterRegistrationBean<UserFilter>(); registration.setFilter(filter1);
	  registration.addUrlPatterns("/*"); registration.setName("filter1");
	  
	  //设置优先级别 registration.setOrder(1);
	  
	  return registration; }
	 

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new HandlerInterceptor() {
		}).addPathPatterns("/check");
	}
}
