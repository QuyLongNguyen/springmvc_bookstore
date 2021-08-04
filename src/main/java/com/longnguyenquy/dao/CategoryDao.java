package com.longnguyenquy.dao;

import java.util.List;

import com.longnguyenquy.entity.Category;

public interface CategoryDao {
	
	public List<Category> getCategories();
	
	public Category getCategory(int id);
	
	public Category getCategory(String name);
		
	public void saveOrUpdateCategory(Category category);
	
	public void deleteCategory(int id);
}
