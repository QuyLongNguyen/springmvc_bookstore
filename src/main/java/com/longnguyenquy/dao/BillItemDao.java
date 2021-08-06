package com.longnguyenquy.dao;

import java.util.List;

import com.longnguyenquy.entity.Bill;
import com.longnguyenquy.entity.BillItem;

public interface BillItemDao {
	
	void saveBillItem(BillItem billItem);
	
	List<BillItem> getBillItemsOf(Bill bill);
	
		
}
