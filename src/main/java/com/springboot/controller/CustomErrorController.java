package com.springboot.controller;

import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.exception.CustomRunTimeException;

@Controller
public class CustomErrorController implements ErrorController{

	public String getErrorPath() {
		return "/error";
	}
	
	@RequestMapping("throw-custom-error")
	public String customErrorThrow()
	{
		/*try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		boolean f=false;
		if(!f) {
			throw new CustomRunTimeException("Custom Exception Message");
		}
		
		return "Not meant to show";
	}
	
	@RequestMapping("global-error")
	public String unknownError()
	{
		/*try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		boolean flag=false;
		if(!flag) {
			int num = 1/0;
		}
		
		return "Not meant to show";
	}
	@RequestMapping("/error")
	  
	  @ResponseBody public String error(HttpServletRequest request, Exception exception) {
		Integer statusCode = (Integer)
	  request.getAttribute("javax.servlet.error.status_code"); 
	  Exception ex = (Exception) request.getAttribute("javax.servlet.error.exception"); return
	  String.
	  format("<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>" +
	  "<div>Exception Message: <b>%s</b></div><body></html>", statusCode,
	  exception==null? "N/A": exception.getMessage()); }
	 
	
}
