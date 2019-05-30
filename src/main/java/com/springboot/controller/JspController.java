package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.beans.BindingObject;

@Controller
public class JspController {

	@RequestMapping("test")
	public String test()
	{
		return "testJsp"; 
	}
	
	@RequestMapping("model-test")
	public String modelTest(ModelMap modelMap)
	{
		modelMap.addAttribute("test", "Model Value");
		return "testJsp";
	}
	
	@RequestMapping("model-and-view")
	public ModelAndView modelAndViewTest(ModelMap modelMap)
	{
		modelMap.addAttribute("modelAndViewMapKey", "modelAndViewMap Value");
		modelMap.addAttribute("obj", new BindingObject());
		return new ModelAndView("testJsp", modelMap);
	}
}
