package com.longnguyenquy.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.longnguyenquy.entity.Book;
import com.longnguyenquy.entity.Category;
import com.longnguyenquy.service.BookService;
import com.longnguyenquy.service.CategoryService;

@Controller
@RequestMapping("/admin/books")
public class BookController {

	@Autowired
	BookService bookService;
	
	@Autowired
	CategoryService categoryService;
	
	
	@GetMapping(value = {"","/"})
	public String manageBooks(Model model) {
		
		List<Book> books = bookService.getBooks();
		
		model.addAttribute("books", books);
		
		return "/admin/admin-books";
	}
	
	@GetMapping("/add-book")
	public String showBookForm(Model model) {
		
		Book book = new Book();
		List<Category> categories = categoryService.getCategories();
		
		model.addAttribute("book",book);
		model.addAttribute("categories", categories);
		
		return "/admin/book-form";
	}
	
	@GetMapping("/update-book")
	public String showBookForm(@RequestParam("bookId") int bookId, Model model) {
		
		Book book = bookService.getBook(bookId);
		
		List<Category> categories = categoryService.getCategories();
		
		model.addAttribute("book", book);
		
		model.addAttribute("categories",categories);
		
		return "/admin/book-form";
		
	}
	
	@PostMapping("/save-book")
	public String saveBook(@ModelAttribute("book") Book book) {
		
		bookService.saveOrUpdateBook(book);
		
		return "redirect:/admin/books";
	}
	
	@GetMapping("/delete-book")
	public String deleteBook(@ModelAttribute("bookId") int bookId) {
		
		bookService.deleteBook(bookId);
		
		return "redirect:/admin/books";
	}
	

}
