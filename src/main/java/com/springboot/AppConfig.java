package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.springboot.filter.TimeCalc;

@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	LocaleChangeInterceptor localeChangeInterceptor;

	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub

		registry.addInterceptor(new TimeCalc()).addPathPatterns("/form*");
		registry.addInterceptor(localeChangeInterceptor);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/public", "classpath:/static/", "classpath:/downloadable/",
						"file:///C:/Users/Parthasarathy/Pictures/")
				.setCachePeriod(31556926).resourceChain(true).addResolver(new PathResourceResolver());

		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
