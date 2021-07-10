package com.longnguyenquy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyenquy.dao.CategoryDao;
import com.longnguyenquy.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
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
	public void saveOrUpdateCategory(Category category) {
		
		categoryDao.saveOrUpdateCategory(category);

	}

	@Override
	@Transactional
	public void deleteCategory(int id) {
		
		categoryDao.deleteCategory(id);
	}

}
