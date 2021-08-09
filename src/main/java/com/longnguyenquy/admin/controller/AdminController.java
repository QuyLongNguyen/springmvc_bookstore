package com.longnguyenquy.admin.controller;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ServletContext servletContext;
	
	@GetMapping(value = {"","/"})
	public String showAdminPage() {
		
		return "/admin/index";
	}
	
	
}
