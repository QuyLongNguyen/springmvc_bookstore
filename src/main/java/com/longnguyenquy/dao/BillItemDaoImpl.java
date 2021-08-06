package com.longnguyenquy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.longnguyenquy.entity.Bill;
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
	
	@Override
	public List<BillItem> getBillItemsOf(Bill bill){
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<BillItem> query = session.createQuery("select bi from BillItem bi join bi.bill b "
				+ "where b.billId = :billId",BillItem.class);
		query.setParameter("billId", bill.getBillId());
		
		List<BillItem> billItems = query.getResultList();
		
		return billItems;
	}
	
	

}
