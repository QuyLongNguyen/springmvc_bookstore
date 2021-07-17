package com.longnguyenquy.dao;


import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.query.Query;
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

		Query<Book> query = session.createQuery("from Book", Book.class);

		List<Book> books = (List<Book>) query.getResultList();

		return books;
	}

	@Override
	public List<Book> getBooks(int categoryId) {

		Session session = sessionFactory.getCurrentSession();

		Query<Book> query = session.createQuery("select b from Book b join b.category c "
				+ "where c.categoryId = :categoryId",Book.class);
		query.setParameter("categoryId", categoryId);

		List<Book> books = (List<Book>) query.getResultList();

		return books;
	}

	@Override
	public List<Book> getBooksPerPage(int categoryId, int offset, int limit) {
		Session session = sessionFactory.getCurrentSession();

		Query<Book> query = session.createQuery("select b from Book b join b.category c "
				+ "where c.categoryId = :categoryId",Book.class);
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
	
	public List<Book> findBooksByTitle(String keyword){
		Session session = sessionFactory.getCurrentSession();
		
		Query<Book> query = session.createQuery("from Book where title like :keyword or author like :keyword",Book.class);
		query.setParameter("keyword", "%"+keyword+"%");
		
		List<Book> books = query.getResultList();
		
		return books;
		
	}

	@Override
	public void saveOrUpdateBook(Book book) {

		Session session = sessionFactory.getCurrentSession();

		// mapping to category
		Category category = session.get(Category.class, book.getCategoryId());

		// add mapping to category
		book.setCategory(category);

		session.merge(book);

	}

	@Override
	public void deleteBook(int id) {
		Session session = sessionFactory.getCurrentSession();

		Query<Book> query = session.createQuery("delete from Book where bookId in (:book_id)",Book.class);
		query.setParameter("book_id", id);
		query.executeUpdate();

	}

}
