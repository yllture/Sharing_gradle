package com.neuedu.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.neuedu.Interceptor.SessionIdInterceptor;

/**
 * @Configuration 表示该类是一个配置文件类
 * @author Administrator
 * 
 * 实现 WebMvcConfigurer 接口  ,并重写addInterceptors 该方法,表示将拦截器注册到spring框架中
 */
@Configuration
public class MywebConfig implements WebMvcConfigurer {
	 @Bean
	 public SessionIdInterceptor getSessionIdInterceptor(){
	     
	        return new SessionIdInterceptor();
	  }

	 @Override
	  public void addInterceptors(InterceptorRegistry registry) {
		
		 List<String> exclude = new ArrayList<String>();//不拦截的列表
		 	exclude.add("/tologin");
	        exclude.add("/login");
	        exclude.add("/toindex");
	        exclude.add("/tobankshop");
	        exclude.add("/topapershop");
	        exclude.add("/static/**");
	        exclude.add("/toregister");
	        exclude.add("/registerChecktel/**");
	        exclude.add("/registerSendMsg/**");
	        exclude.add("/register");
	        registry.addInterceptor(getSessionIdInterceptor()) 
	                .addPathPatterns("/**")
	        .excludePathPatterns(exclude);
	    }
}
