package com.springboot.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BindingObject {

	
	int id;
	
	@NotNull @Size(min = 2, max = 10)
	String name;
	String value;
	float floatval;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public float getFloatval() {
		return floatval;
	}
	public void setFloatval(float floatval) {
		this.floatval = floatval;
	}
	
}
