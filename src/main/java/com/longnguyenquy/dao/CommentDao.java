package com.longnguyenquy.dao;

import java.util.List;

import com.longnguyenquy.entity.Comment;


public interface CommentDao {
	
	List<Comment> getCommentsByBook(int bookId);
	
	void save(Comment comment);
	
	
}
