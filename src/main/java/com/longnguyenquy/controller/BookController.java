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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	CartService shoppingService;
	
	@GetMapping(value = {"/",""}, params = {"keyword"})
	public String showBooks(@RequestParam("keyword") String keyword ,  Model model) {
		
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("categories", categories);
		
		List<Book> books = bookService.findBooksByKeyword(keyword);
		model.addAttribute("books", books);
		
		if(shoppingService.getCartItems() != null) {
			model.addAttribute("cartCount", shoppingService.getCartItems().size());
		}
		
		Item item = new Item();
		model.addAttribute("item", item);
		
		return "books";
	}
	
	/*
	@GetMapping(value = {"/",""}, params = {"categoryName"} )
	public String showBooksOfCategory(@RequestParam("categoryName") String categoryName, Model model) {
		
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("categories", categories);
		
		Category category = categoryService.getCategory(categoryName);
		List<Book> books = bookService.getBooks(category.getCategoryId());
		model.addAttribute("books", books);
		
		Item item = new Item();
		model.addAttribute("item", item);
		
		if(shoppingService.getCartItems() != null) {
			model.addAttribute("cartCount", shoppingService.getCartItems().size());
		}
		
		return "books";
	}
	*/
	@GetMapping(value = {"/",""}, params = {"categoryName","page"} )
	public String showBooksOfCategory(@RequestParam("categoryName") String categoryName,@RequestParam(value = "page", required = false) int page, Model model) {
		
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("categories", categories);
		
		/*
		List<Book> books = bookService.getBooksSegment(categoryName, page * 2, 2);
		if(page > books.size()) {
			return "404";
		}
		*/
		List<Book> books = bookService.getBooks(categoryService.getCategory(categoryName).getCategoryId());
		model.addAttribute("books", books);
		
		if(shoppingService.getCartItems() != null) {
			model.addAttribute("cartCount", shoppingService.getCartItems().size());
		}
		
		return "books";
	}
	
	
	@GetMapping("/{id}")
	public String showBook(@PathVariable int id,@RequestParam(required = false) boolean buy, Model model) {
		
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("categories", categories);
		
		Book book = bookService.getBook(id);
		
		model.addAttribute("book", book);
		Item item = new Item();
		model.addAttribute("item", item);
		
		if(shoppingService.getCartItems() != null) {
			model.addAttribute("cartCount", shoppingService.getCartItems().size());
		}
		
		return "book";
	}
	
	@PostMapping(value = {"/addToCart"})
	public String showBooks(@ModelAttribute("item") Item item , RedirectAttributes redirectAttributes ) {
		
		
		shoppingService.addItem(item);
		redirectAttributes.addAttribute("bookId", item.getBookId());
		return "redirect:/books/{bookId}?buy=true";
	}
	
	
}
