package com.longnguyenquy.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.longnguyenquy.dto.AuthenticationDto;
import com.longnguyenquy.entity.Cart;
import com.longnguyenquy.entity.Item;
import com.longnguyenquy.entity.User;


@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public
	void saveCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(cart);
	}
	@Override
	public void deleteCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(cart);
	}
	
	@Override
	public List<Item> getItemsOf(Cart cart) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Item> query = session.createQuery("select i from Item i join i.cart c where c.cartId = :cartId", Item.class);
		query.setParameter("cartId", cart.getCartId());
		
		List<Item> items = query.getResultList();
		
		return items;
	}
	

}
