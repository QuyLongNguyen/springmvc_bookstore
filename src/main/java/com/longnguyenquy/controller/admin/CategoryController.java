package com.longnguyenquy.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.longnguyenquy.entity.Category;
import com.longnguyenquy.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	
	
	@Autowired
	CategoryService categoryService;
	
	/*
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmer);
	}
	 */
	
	
	@GetMapping(value = {"","/"})
	public String showCategories(Model model) {
		
		List<Category> categories = categoryService.getCategories();
		
		model.addAttribute("categories", categories);
		
		return "/admin/admin-categories";
	}
	
	
	@GetMapping("/add-category")
	public String showCategoryForm(Model model) {
		
		Category category = new Category();
		
		model.addAttribute("category",category);
		
		
		return "/admin/category-form";
	}
	
	
	@GetMapping("/update-category")
	public String showBookForm(@RequestParam("categoryId") int categoryId, Model model) {
		
		Category category = categoryService.getCategory(categoryId);
		
		model.addAttribute("category", category);
	
		return "/admin/category-form";
		
	}
	
	@PostMapping("/save-category")
	public String saveCategory(@ModelAttribute("category") Category category) {
		
			categoryService.saveOrUpdateCategory(category);
			
			return "redirect:/admin/categories";
		
	}
	
	@GetMapping("/delete-category")
	public String deleteBook(@ModelAttribute("categoryId") int categoryId) {
		
		categoryService.deleteCategory(categoryId);
		
		return "redirect:/admin/categories";
	}
	

	
	
	
}
