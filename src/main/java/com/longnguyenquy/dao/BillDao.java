package com.longnguyenquy.dao;

import java.util.List;

import com.longnguyenquy.entity.Bill;

public interface BillDao {
	
	List<Bill> getBills();
	
	Bill getBill(int id);
	
	void saveBill(Bill bill);
	
}
