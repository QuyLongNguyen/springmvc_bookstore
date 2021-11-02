package com.longnguyenquy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.longnguyenquy.dao.CommentDao;
import com.longnguyenquy.entity.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;
	
	@Override
	@Transactional
	public List<Comment> getCommentsByBook(int bookId) {
		
		return commentDao.getCommentsByBook(bookId);
	}

	@Override
	@Transactional
	public void save(Comment comment) {
		
		commentDao.save(comment);
		
	}

}
