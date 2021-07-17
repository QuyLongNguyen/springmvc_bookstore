package com.longnguyenquy.service;

import java.util.List;

import com.longnguyenquy.entity.Book;

public interface BookService {
	public List<Book> getBooks();
	
	public List<Book> getBooks(int categoryId);
	
	public List<Book> findBooksByKeyword(String keyword);
	
	public Book getBook(int id);
	
	public void saveOrUpdateBook(Book book);
	
	public void deleteBook(int id);
}
