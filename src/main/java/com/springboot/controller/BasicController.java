package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

	@RequestMapping("stat")
	public String status()
	{
		return "App is Up";
	}
}
