package com.longnguyenquy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.longnguyenquy.entity.Bill;

@Repository
public class BillDaoImpl implements BillDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Bill> getBills(){
		Session session = sessionFactory.getCurrentSession();
		
		Query<Bill> query = session.createQuery("from Bill", Bill.class);
		
		List<Bill> bills = query.getResultList();
	
		return bills;
	}
	
	@Override
	public Bill getBill(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Bill bill = session.get(Bill.class, id);
		
		return bill;
	}
	
	@Override
	public void saveBill(Bill bill) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(bill);

	}

}
