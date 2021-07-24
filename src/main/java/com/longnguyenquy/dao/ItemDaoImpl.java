package com.longnguyenquy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	 	

}
