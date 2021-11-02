package com.longnguyenquy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.longnguyenquy.entity.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Comment> getCommentsByBook(int bookId) {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Comment> query = session.createQuery("from Comment where book.bookId = :bookId",Comment.class);
		query.setParameter("bookId", bookId);
		List<Comment> comments = query.getResultList();
		
		return comments;
		
	}
	
	@Override
	public void save(Comment comment) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(comment);
	}

}
