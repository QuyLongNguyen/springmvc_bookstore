package com.longnguyenquy.service;

import java.util.List;

import com.longnguyenquy.entity.Category;

public interface CategoryService {
	
	public List<Category> getCategories();
	
	public Category getCategory(int id);
	
	
	public void saveOrUpdateCategory(Category category);
	
	public void deleteCategory(int id);
}