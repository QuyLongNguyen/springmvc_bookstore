package com.longnguyenquy.service;

import java.util.List;

import com.longnguyenquy.dto.CategoryAndBooks;
import com.longnguyenquy.entity.Category;

public interface CategoryService {
	
	public List<Category> getCategories();
	
	public Category getCategory(int id);
	
	public Category getCategory(String name);
	
	List<CategoryAndBooks> getCategoriesWithBooks(int number);
	
	public void saveOrUpdateCategory(Category category);
	
	public void deleteCategory(int id);
}
