package com.longnguyenquy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.longnguyenquy.dao.CartDao;
import com.longnguyenquy.entity.Book;
import com.longnguyenquy.entity.Category;
import com.longnguyenquy.entity.Item;
import com.longnguyenquy.service.BookService;
import com.longnguyenquy.service.CartService;
import com.longnguyenquy.service.CategoryService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CartService cartService;
	
	@GetMapping(value = {"/",""})
	public String showBooks( Model model) {
		
		List<Book> books = bookService.getBooks();
		model.addAttribute("books", books);
		
		Item item = new Item();
		model.addAttribute("item", item);
		
		return "books";
	}
	
	@GetMapping(value = {"/",""}, params = {"keyword"})
	public String showBooks(@RequestParam("keyword") String keyword ,  Model model) {
		
		List<Book> books = bookService.findBooksByKeyword(keyword);
		model.addAttribute("books", books);
		model.addAttribute("category", keyword);
		Item item = new Item();
		model.addAttribute("item", item);
		
		return "books";
	}
	
	@GetMapping(value = {"/",""}, params = {"categoryId"} )
	public String showBooks(@RequestParam("categoryId") int categoryId, Model model) {
		
		
		Category category = categoryService.getCategory(categoryId);
		List<Book> books = bookService.getBooks(categoryId);
		model.addAttribute("books", books);
		model.addAttribute("category", category.getCategoryName());
		Item item = new Item();
		model.addAttribute("item", item);
		
		return "books";
	}
	
	@GetMapping("/{id}")
	public String showBook(@PathVariable int id, Model model) {
		
		
		Book book = bookService.getBook(id);
		
		model.addAttribute("book", book);
		
		return "book";
	}
	
	@PostMapping(value = {"/buy"})
	public String showBooks(@ModelAttribute("item") Item item ) {
		
		System.out.println(item);
		cartService.addItem(item);
		
		return "redirect:/books";
	}
	
	
}
