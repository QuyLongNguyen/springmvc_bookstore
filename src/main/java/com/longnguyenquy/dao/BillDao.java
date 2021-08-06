package com.longnguyenquy.dao;

import java.math.BigDecimal;
import java.util.List;

import com.longnguyenquy.entity.Bill;
import com.longnguyenquy.entity.BillItem;

public interface BillDao {
	
	List<Bill> getBills();
	
	List<Bill> getBills(long userId);
	
	List<BillItem> getItemsOf(Bill bill);
	
	BigDecimal getTotalPrice(Bill bill);
	
	Bill getBill(int id);
	
	void saveBill(Bill bill);
	
	void deleteBill(int id);
	
}
