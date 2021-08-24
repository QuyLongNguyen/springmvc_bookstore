package com.longnguyenquy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.longnguyenquy.entity.*;

@Repository
public class UserDaoImpl implements UserDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers(){
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("from User", User.class);
		
		List<User> users = query.getResultList();
		
		return users;
	}
	
	
	@Override
	public User getUser(long id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		User user = session.get(User.class, id);
		
		return user;
	}
	
	@Override
	public User findByUserName(String theUserName) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// now retrieve/read from database using username
		Query<User> theQuery = session.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", theUserName);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}

		return theUser;
	}

	@Override
	public User findByEmail(String email) {
		
		Session session = sessionFactory.getCurrentSession();
		User user = null;
		try {
			Query<User> query = session.createQuery("from User where email = :email",User.class);
			query.setParameter("email", email);
			user = query.getSingleResult();
			
		}catch (RuntimeException e) {
			user = null;
		}
		return user;
	}
	
	@Override
	public User findByToken(String token) {
		
		Session session = sessionFactory.getCurrentSession();
		User user = null;
		try {
			Query<User> query = session.createQuery("from User where resetPasswordToken = :token",User.class);
			query.setParameter("token",token);
			user = query.getSingleResult();
			
		}catch (RuntimeException e) {
			user = null;
		}
		return user;
	}
	
	@Override
	public void save(User theUser) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the user ... finally LOL
		currentSession.saveOrUpdate(theUser);
	}




}
