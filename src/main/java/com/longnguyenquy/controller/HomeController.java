package com.longnguyenquy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.longnguyenquy.entity.Category;
import com.longnguyenquy.service.CategoryService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping(value = {"/",""})
	public String showHome(Model model) {
		
		List<Category> categories = categoryService.getCategories();
		
		model.addAttribute("categories", categories);
		
		return "home";
	}
	
	

}
