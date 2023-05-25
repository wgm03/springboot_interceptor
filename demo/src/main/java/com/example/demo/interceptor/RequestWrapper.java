package com.example.demo.interceptor;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
/*HttpServletRequestWrapper是一个实现了HttpServletRequest接口的抽象类。
它的主要作用是:用于包装HttpServletRequest对象,可以扩展原始请求的功能。
当我们想要包装HttpServletRequest以提供额外的功能时,
可以继承HttpServletRequestWrapper,然后重写需要的方法。*/
 
public class RequestWrapper extends HttpServletRequestWrapper {
    private final String body;
    //有参构造函数
    public RequestWrapper(HttpServletRequest request) {
        super(request);
        StringBuilder stringBuilder = new StringBuilder();
        //缓冲字符流读
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                //定义一个字符数组
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                //每次读取一个字符数组
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                	//将读取到的数据添加到stringBuilder中
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
 
        } finally {
            if (inputStream != null) {
                try {
                	//最终还要释放输入流所占据的资源
                    inputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //将读取到的数据保存到body中
        body = stringBuilder.toString();
    }
 //重写getInputStream()方法,返回一个以body属性的字节数组为数据源的输入流。
    @Override
    public ServletInputStream getInputStream() throws IOException {
		/*
		 * ByteArrayOutputStream 是字节数组输出流,它的作用是: 
		 * 将数据写入一个字节数组中。 它内部持有一个字节数组, 我们可以通过
		 * write() 方法往这个数组中写入数据, 
		 * 最后通过 toByteArray() 方法获取整个字节数组。
		 */
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
        ServletInputStream servletInputStream = new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }
            @Override
            public boolean isReady() {
                return false;
            }
            @Override
            public void setReadListener(ReadListener readListener) {
            }
            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
        return servletInputStream;
 
    }
 //重写getReader()方法,返回一个以上述输入流为数据源的BufferedReader。
    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }
 
    public String getBody() {
        return this.body;
    }
 
}
