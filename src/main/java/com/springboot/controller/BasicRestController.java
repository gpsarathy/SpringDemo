package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.beans.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Available rest controller api's")
public class BasicRestController {

	static List<Product> products=new ArrayList<Product>();
	
	static
	{
		products.add(new Product(1,"Paper",10f));
		products.add(new Product(2,"Pen",0.1f));
	}
	@ApiOperation(value = "Returning all products")
	@GetMapping(value="product")
	public List<Product> getProducts() {
		return products;
	}
	

	@ApiOperation(value = "Get the product by ID")
	@GetMapping(value="/product/{id}")
	public Resource<Product> getProduct(@PathVariable int id) {
		
		Link selfLink = linkTo(methodOn(BasicRestController.class).getProduct(id)).withRel("self");
		
		Resource<Product> resource=new Resource<Product>(products.get(id), selfLink);
		resource.add( linkTo(methodOn(BasicRestController.class).getProducts()).withRel("getAll"));
		return resource;
	}
	
	
}
