package com.springboot.exception;

public class CustomRunTimeException extends RuntimeException{

	public CustomRunTimeException(String string) {
		super(string);
	}

}
