package com.longnguyenquy.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.longnguyenquy.entity.Book;
import com.longnguyenquy.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Category> getCategories() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Category",Category.class);
		
		List<Category> categories = query.getResultList();
		
		return categories;
	}
	public Category getCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Category category = session.get(Category.class, id);
		
		return category;
		
	}
	
	
	@Override
	public void saveOrUpdateCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		
		session.merge(category);
		
	}

	@Override
	public void deleteCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Category category = session.get(Category.class, id);
		
		List<Book> books = category.getBooks();
		
		for(Book book: books) {
			book.setCategory(null);
		}
		
		session.delete(category);
	}

}
