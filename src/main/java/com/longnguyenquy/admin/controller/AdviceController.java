package com.longnguyenquy.admin.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class AdviceController {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handle404Error(Exception e) {
		return "404";
	}
	
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleError400(Exception e) {
		return "400";
	}
	
	
	
}
