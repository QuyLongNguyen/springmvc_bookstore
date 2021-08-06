package com.longnguyenquy.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.longnguyenquy.entity.Bill;
import com.longnguyenquy.entity.BillItem;

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
	public List<Bill> getBills(long userId){
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Bill> query = session.createQuery("from Bill where user.id = :userId", Bill.class);
		query.setParameter("userId", userId);
		
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
	public BigDecimal getTotalPrice(Bill bill) {
		
		BigDecimal total = new BigDecimal(0);
		
		List<BillItem> billItems = getItemsOf(bill);
		
		for(BillItem billItem: billItems) {
			total = total.add(billItem.getPrice());
		}
		
		return total;
	}
	
	@Override
	public void saveBill(Bill bill) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(bill);

	}
	
	@Override
	public List<BillItem> getItemsOf(Bill bill){
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<BillItem> query = session.createQuery("from BillItem b where b.bill = :bill", BillItem.class);
		query.setParameter("bill", bill);
		
		List<BillItem> billItems = query.getResultList();
		
		return billItems;
	}

	@Override
	public void deleteBill(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Bill bill = session.get(Bill.class, id);
		
		session.delete(bill);
		
	}
}
