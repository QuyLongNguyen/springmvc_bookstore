package com.longnguyenquy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.longnguyenquy.dto.CategoryDto;
import com.longnguyenquy.entity.Book;
import com.longnguyenquy.entity.Category;
import com.longnguyenquy.entity.Item;
import com.longnguyenquy.entity.User;
import com.longnguyenquy.service.BookService;
import com.longnguyenquy.service.CategoryService;
import com.longnguyenquy.service.ShoppingService;
import com.longnguyenquy.service.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ShoppingService shoppingService;
	
	@GetMapping(value = {"/",""})
	public String showHome(Model model) {
		
		List<Category> categories = categoryService.getCategories();
		
		model.addAttribute("categories", categories);
		
		List<CategoryDto> categoriesDto = categoryService.getCategoriesWithBooks(4);
	
		model.addAttribute("categoriesDto", categoriesDto);
		
		
		if(shoppingService.getCartItems() != null) {
			model.addAttribute("cartCount", shoppingService.getCartItems().size());
		}
		
		for(CategoryDto categoryDto: categoriesDto) {
			System.out.println(categoryDto.getBooks());
		}
	
		return "home";
	}
	
	
}
