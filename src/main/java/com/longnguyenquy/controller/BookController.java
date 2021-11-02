package com.longnguyenquy.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;

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
import com.longnguyenquy.entity.Comment;
import com.longnguyenquy.entity.Item;
import com.longnguyenquy.service.BookService;
import com.longnguyenquy.service.CartService;
import com.longnguyenquy.service.CategoryService;
import com.longnguyenquy.service.CommentService;
import com.longnguyenquy.service.UserService;

import javassist.expr.NewArray;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CartService shoppingService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CommentService commentService;
	
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
	public String showBooksOfCategory(@RequestParam("categoryName") String categoryName,@RequestParam("page") int page, Model model) {
		
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("categories", categories);
		
		
		List<Book> books = bookService.getBooks(categoryService.getCategory(categoryName).getCategoryId());
		
		int booksPerPage = 2;
		int startIndex = page * booksPerPage, endIndex = startIndex + booksPerPage;
		if(endIndex >= books.size()) {
			endIndex = books.size();
		}
		
		List<Book> subList = books.subList(startIndex, endIndex);
		model.addAttribute("books", subList);
		model.addAttribute("total", (books.size()+1) / booksPerPage);
		
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
		
		List<Comment> comments = commentService.getCommentsByBook(id);
		model.addAttribute("comments", comments);
		
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
	
	@PostMapping("/{id}/comment")
	public String writeComment(ServletRequest request, @PathVariable("id") int bookId ,RedirectAttributes redirectAttributes) {
		
		String content =  request.getParameter("content");

		Comment comment = new Comment(userService.currentUser(),bookService.getBook(bookId),content,-1);
		commentService.save(comment);
		
		redirectAttributes.addAttribute("bookId", bookId);
		return "redirect:/books/{bookId}";
	
	}
	
}
