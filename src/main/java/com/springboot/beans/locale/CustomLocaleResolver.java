package com.springboot.beans.locale;

import java.nio.charset.Charset;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class CustomLocaleResolver {

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource getReloadableResourceBundleMessageSource()
	{
		ReloadableResourceBundleMessageSource rrbms = new ReloadableResourceBundleMessageSource();
		rrbms.setDefaultEncoding("UTF-8");
		rrbms.setBasename("classpath:messages");
		
		return rrbms;
	}
	
	@Bean(name = DispatcherServlet.LOCALE_RESOLVER_BEAN_NAME)
	public SessionLocaleResolver getSessionLocaleResolver()
	{
		SessionLocaleResolver sessionLocaleResolver =new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		return sessionLocaleResolver;
	}
	
	@Bean
	public LocaleChangeInterceptor getLocaleChangeInterceptor()
	{
		LocaleChangeInterceptor localeChangeInterceptor =new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}
}
