package com.example.demo.interceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HandlerInterceptor implements org.springframework.web.servlet.HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle生效了.......");
		System.out.println("请求头的类型:"+request.getContentType());
		RequestWrapper requestWrapper = new RequestWrapper(request);
        String body = requestWrapper.getBody();
        System.out.println(body);
		return true;
	}

	
}
