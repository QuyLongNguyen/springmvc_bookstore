package com.longnguyenquy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.longnguyenquy.entity.Book;
import com.longnguyenquy.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String showBooks(Model model) {
		
		List<Book> books = bookService.getBooks();
		model.addAttribute("books", books);
		return "books";
	}
	

}
