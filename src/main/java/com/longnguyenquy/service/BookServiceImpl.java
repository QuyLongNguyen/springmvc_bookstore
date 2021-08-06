package com.longnguyenquy.service;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;


import org.apache.commons.io.FilenameUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.longnguyenquy.dao.BookDao;
import com.longnguyenquy.dao.CategoryDao;
import com.longnguyenquy.dto.CategoryAndBooks;
import com.longnguyenquy.entity.Book;
import com.longnguyenquy.entity.Category;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
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
	public List<Book> findBooksByKeyword(String keyword){
		
		return bookDao.findBooksByTitle(keyword);
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
		
		Book book = bookDao.getBook(id);
		
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
