package com.longnguyenquy.dto;

import java.util.List;

import com.longnguyenquy.entity.Book;

public class CategoryDto {

	private String categoryName;
	
	private List<Book> books;

	
	public CategoryDto(String categoryName, List<Book> books) {
		super();
		this.categoryName = categoryName;
		this.books = books;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
