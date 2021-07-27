package com.longnguyenquy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.longnguyenquy.entity.Cart;
import com.longnguyenquy.entity.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Item getItem(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Item item = session.get(Item.class, id);
		
		return item;
		
	}
	
	@Override
	public void saveItem(Item item) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(item);
		
	}

	@Override
	public void deleteItem(Item item) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(item);

	}

	@Override
	public void deleteItemsOf(Cart cart) {
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Item> items = cart.getItems();
		
		for(Item item: items) {
			session.delete(item);
		}
	}

}
