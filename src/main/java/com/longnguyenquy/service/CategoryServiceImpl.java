package com.longnguyenquy.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.longnguyenquy.dao.BookDao;
import com.longnguyenquy.dao.CategoryDao;
import com.longnguyenquy.dto.CategoryDto;
import com.longnguyenquy.entity.Book;
import com.longnguyenquy.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	BookDao bookDao;
	
	@Override
	@Transactional
	public List<Category> getCategories() {
		
		
		return categoryDao.getCategories();
	}

	@Override
	@Transactional
	public Category getCategory(int id) {
		
		return categoryDao.getCategory(id);
	}
	
	@Override
	@Transactional
	public Category getCategory(String name) {
		
		return categoryDao.getCategory(name);
	}

	@Override
	@Transactional
	public void saveOrUpdateCategory(Category category) {
		
		categoryDao.saveOrUpdateCategory(category);

	}
	
	@Override
	@Transactional
	public List<CategoryDto> getCategoriesWithBooks(int number){
			
		List<Category> categories = categoryDao.getCategories();
		List<CategoryDto> categoriesDto  = new LinkedList<CategoryDto>();
		for(Category category: categories) {
			List<Book> books = bookDao.getBooksByCategory(category.getCategoryId(), number);
			categoriesDto.add(new CategoryDto(category.getCategoryName(), books));
		}
		return categoriesDto;
	}
	

	@Override
	@Transactional
	public void deleteCategory(int id) {
		
		categoryDao.deleteCategory(id);
	}

}
