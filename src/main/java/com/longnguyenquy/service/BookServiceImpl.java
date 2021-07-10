package com.longnguyenquy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyenquy.dao.BookDao;
import com.longnguyenquy.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	@Transactional
	public List<Book> getBooks() {
		
		return bookDao.getBooks();
	}
	
	@Override
	@Transactional
	public Book getBook(int id) {
		
		return bookDao.getBook(id);
	}

	@Override
	@Transactional
	public void saveOrUpdateBook(Book book) {
		
		bookDao.saveOrUpdateBook(book);
		
	}

	@Override
	@Transactional
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
		
	}

}
