package com.longnguyenquy.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.longnguyenquy.entity.Book;
import com.longnguyenquy.entity.Category;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Book> getBooks() {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Book",Book.class);
		
		List<Book> books = (List<Book>)query.getResultList();
		
		
		return books;
	}
	
	@Override
	public Book getBook(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Book book = session.get(Book.class, id);
		
		return book;
		
	}

	@Override
	public void saveOrUpdateBook(Book book) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Category category = session.get(Category.class, book.getCategoryId());
		
		book.setCategory(category);
		
		session.saveOrUpdate(book);
		
	
	}

	@Override
	public void deleteBook(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Book book = session.get(Book.class, id);
		session.delete(book);
		
	}

}
