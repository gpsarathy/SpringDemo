package com.springboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.beans.BindingObject;

@Controller
public class JspController {

	@RequestMapping("test")
	public String test()
	{
		return "testJsp"; 
	}
	
	@RequestMapping("musicHome")
	public String music()
	{
		return "musicHome"; 
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
	
	@RequestMapping(value="form-test")
	public ModelAndView formTest(ModelMap modelMap)
	{
		
		modelMap.addAttribute("bindingObject",new BindingObject());
		return new ModelAndView("formSubmit");
	}
	
	@RequestMapping(value="form-data-test" , method = RequestMethod.POST)
	public ModelAndView formDataTest(ModelMap modelMap, @Valid BindingObject bindObj, BindingResult result)
	{
		if(result.hasErrors())
		{
			modelMap.addAttribute("bindingObject",new BindingObject());
			return new ModelAndView("formSubmit");
		}
		return new ModelAndView("formData");
	}
	
	@RequestMapping(value = "upload")
	public ModelAndView fileUpload()
	{
		ModelAndView modelAndView =new ModelAndView("upload");
		return modelAndView;
	}
	
	@RequestMapping(value = "uploadFile" ,method = RequestMethod.POST )
	public String fileUploadPst(@RequestParam("file") MultipartFile file)
	{
		try {	

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get("C:\\workspace\\Web\\" + file.getOriginalFilename());
            Files.write(path, bytes);
            
        } catch (IOException e) {
            e.printStackTrace();
            return "Fail";
        }
		return "success";
	}
	
}
