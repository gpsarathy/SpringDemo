package com.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.filter.TimeCalc;


@Configuration
public class AppConfig implements WebMvcConfigurer {

	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		
		registry.addInterceptor(new TimeCalc()).addPathPatterns("/form*");
	}
	
}
