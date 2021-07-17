package com.longnguyenquy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.longnguyenquy.entity.Book;
import com.longnguyenquy.entity.Category;
import com.longnguyenquy.service.BookService;
import com.longnguyenquy.service.CategoryService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping(value = {"/",""})
	public String showBooks( Model model) {
		
		List<Book> books = bookService.getBooks();
		model.addAttribute("books", books);
		
		return "books";
	}
	
	@GetMapping(value = {"/",""}, params = {"keyword"})
	public String showBooks(@RequestParam("keyword") String keyword ,  Model model) {
		
		List<Book> books = bookService.findBooksByKeyword(keyword);
		model.addAttribute("books", books);
		model.addAttribute("category", keyword);
		
		return "books";
	}
	
	@GetMapping(value = {"/",""}, params = {"categoryId"} )
	public String showBooks(@RequestParam("categoryId") int categoryId, Model model) {
		
		
		Category category = categoryService.getCategory(categoryId);
		List<Book> books = bookService.getBooks(categoryId);
		model.addAttribute("books", books);
		model.addAttribute("category", category.getCategoryName());
		
		return "books";
	}
	
	@GetMapping("/{id}")
	public String showBook(@PathVariable int id, Model model) {
		
		
		Book book = bookService.getBook(id);
		
		model.addAttribute("book", book);
		
		return "book";
	}
}
