package com.longnguyenquy.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	/*
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmer);
	}
	 */
	@GetMapping(value = {"","/"} )
	public String manageBooks(Model model) {
		
		List<Book> books = bookService.getBooks();
		
		model.addAttribute("books", books);
		
		return "/admin/admin-books";
	}
	
	@GetMapping(value = {"","/"} , params = {"categoryId"})
	public String manageBooks(@RequestParam("categoryId") int categoryId , Model model) {
		
		List<Book> books = bookService.getBooks(categoryId);
		
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
	public String saveBook(@Valid @ModelAttribute("book") Book book, RedirectAttributes redirectAttributes ,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/admin/book-form";
		}
		else {
			bookService.saveOrUpdateBook(book);
			redirectAttributes.addAttribute("categoryId", book.getCategoryId());
			return "redirect:/admin/books?categoryId={categoryId}";
		}
	}
	
	@GetMapping("/delete-book")
	public String deleteBook(@ModelAttribute("bookId") int bookId ) {
		
		bookService.deleteBook(bookId);
		
		return "redirect:/admin/books";
	}
	

}
