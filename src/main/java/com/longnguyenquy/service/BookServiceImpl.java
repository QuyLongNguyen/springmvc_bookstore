package com.longnguyenquy.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.longnguyenquy.dao.BookDao;
import com.longnguyenquy.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	ServletContext servletContext;

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
		
		//create and save file
		MultipartFile multipartFile = book.getImage();
		
		if (!multipartFile.isEmpty()) {
			String fileExtension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
	
			String fileName = "book_cover_" + book.getBookId() + "." +fileExtension;
			
			String imageDir = servletContext.getRealPath("/") + "resources\\images\\" + fileName;
			book.setCover(fileName);
			
			MultiPartFilesUtilsService multiPartFilesUtils = new MultiPartFilesUtilsService(multipartFile);
			multiPartFilesUtils.saveFileTo(imageDir, true);	
		}
	}

	@Override
	@Transactional
	public void deleteBook(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Book book = session.get(Book.class, id);
		
		String imageDir = servletContext.getRealPath("/") + "resources\\images\\" + book.getCover();
		File file = new File(imageDir);
		if (file.exists()) {
			file.delete();
		}
		
		bookDao.deleteBook(book.getBookId());
		
	}

	@Override
	@Transactional
	public List<Book> getBooks(int categoryId) {
		
		return bookDao.getBooks(categoryId);
	}

}
