package com.example.demo.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.example.demo.interceptor.RequestWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
@Component
public class UserFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter Begin....");
		/*
		 * //放行 chain.doFilter(request, response);
		 */
		 ServletRequest requestWrapper = null;
	        if(request instanceof HttpServletRequest) {
	            requestWrapper = new RequestWrapper((HttpServletRequest) request);
	        }
	        //判断是否需要包装
	        if(requestWrapper == null) {
	        	// chain.doFilter(request, response); 直接放行请求,传递给下一个Filter或Servlet。
	            chain.doFilter(request, response);
	        } else {
	        	// 构建RequestWrapper请求包装,
	        	//然后chain.doFilter(requestWrapper, response);
	        	//将包装后的请求传递给下一个Filter或Servlet。
	            chain.doFilter(requestWrapper, response);
	        }

		
	}

}
