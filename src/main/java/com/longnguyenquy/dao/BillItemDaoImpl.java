package com.longnguyenquy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.longnguyenquy.entity.BillItem;

@Repository
public class BillItemDaoImpl implements BillItemDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveBillItem(BillItem billItem) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(billItem);
	}

}
