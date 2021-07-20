package com.longnguyenquy.dao;

import java.util.LinkedList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.longnguyenquy.entity.Book;
import com.longnguyenquy.entity.Cart;
import com.longnguyenquy.entity.Item;
import com.longnguyenquy.entity.User;
import com.longnguyenquy.service.UserService;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	UserDao userDao;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addItem(Item item) {
		
		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("Inside add item");
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userDao.findByUserName(userName);
		
		if(user.getCart() == null) {
			System.out.println("insider cart null");
			Cart cart = new Cart(user, new LinkedList<Item>());
			user.setCart(cart);
			session.save(cart);
		}
		
		System.out.println("Before get book");
		Book book = session.get(Book.class, item.getBookId());
		
		item.setBook(book);
		
		Cart cart = user.getCart();
		item.setCart(cart);
		cart.getItems().add(item);
	
		session.save(item);

	}

	@Override
	public void deleteItem(Item item) {
		Session session = sessionFactory.getCurrentSession();
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userDao.findByUserName(userName);
		Cart cart = user.getCart();
		cart.getItems().remove(item);
		
		session.delete(item);
		

	}

}
