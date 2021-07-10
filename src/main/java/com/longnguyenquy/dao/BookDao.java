package com.longnguyenquy.dao;

import java.util.List;

import com.longnguyenquy.entity.Book;

public interface BookDao {

	public List<Book> getBooks();
	
	public Book getBook(int id);
	
	public void saveOrUpdateBook(Book book);
	
	public void deleteBook(int id);
	
	
}
