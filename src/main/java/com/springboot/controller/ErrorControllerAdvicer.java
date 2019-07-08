package com.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.exception.CustomRunTimeException;

@ControllerAdvice
public class ErrorControllerAdvicer {

	@ExceptionHandler(value = RuntimeException.class)
	public ModelAndView errorPage(HttpServletRequest request, Exception ex)
	{
		ModelAndView mView =new ModelAndView("error/errorPage");
		mView.addObject("ex",ex);
		mView.addObject("url", request.getRequestURI() );
		return mView; 
	}
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView globalErroHandler(HttpServletRequest request, Exception ex)
	{
		ModelAndView mView =new ModelAndView("error/errorPage");
		mView.addObject("ex",ex);
		mView.addObject("url", request.getRequestURI() );
		return mView; 
	}
}
