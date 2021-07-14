package com.longnguyenquy.dao;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.ServletContext;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.longnguyenquy.entity.Book;
import com.longnguyenquy.entity.Category;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	ServletContext servletContext;

	@Override
	public List<Book> getBooks() {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Book", Book.class);

		List<Book> books = (List<Book>) query.getResultList();

		return books;
	}

	@Override
	public List<Book> getBooks(int categoryId) {

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("select b from Book b join b.category c where c.categoryId = :categoryId");
		query.setParameter("categoryId", categoryId);

		List<Book> books = (List<Book>) query.getResultList();

		return books;
	}

	@Override
	public List<Book> getBooks(int categoryId, int offset, int limit) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("select b from Book b join b.category c where c.categoryId = :categoryId");
		query.setParameter("categoryId", categoryId);
		query.setFirstResult(offset);
		query.setMaxResults(limit);

		List<Book> books = (List<Book>) query.getResultList();

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

		// mapping to category
		Category category = session.get(Category.class, book.getCategoryId());

		// add mapping to category
		book.setCategory(category);

		session.saveOrUpdate(book);

	}

	@Override
	public void deleteBook(int id) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Book where bookId in (:book_id)");
		query.setParameter("book_id", id);
		query.executeUpdate();

	}

}
