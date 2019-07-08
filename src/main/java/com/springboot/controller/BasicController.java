package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BasicController {

	@RequestMapping("stat")
	public String status()
	{
		return "App is Up";
	}
	@RequestMapping("/indexPage")
	public ModelAndView home()
	{
		return new ModelAndView("index");
	}

}
