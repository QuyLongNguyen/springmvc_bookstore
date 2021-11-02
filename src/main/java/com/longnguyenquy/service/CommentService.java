package com.longnguyenquy.service;

import java.util.List;

import com.longnguyenquy.entity.Comment;

public interface CommentService {
	
	List<Comment> getCommentsByBook(int bookId);
	
	void save(Comment comment);
}
