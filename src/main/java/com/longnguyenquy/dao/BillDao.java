package com.longnguyenquy.dao;

import java.util.List;

import com.longnguyenquy.entity.Bill;
import com.longnguyenquy.entity.BillItem;

public interface BillDao {
	
	List<Bill> getBills();
	
	Bill getBill(int id);
	
	void saveBill(Bill bill);
	
	List<BillItem> getItemsOf(Bill bill);
	
}
