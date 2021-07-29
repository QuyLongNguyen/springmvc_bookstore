package com.longnguyenquy.service;

import java.util.List;

import com.longnguyenquy.entity.Bill;
import com.longnguyenquy.entity.BillItem;
import com.longnguyenquy.entity.Status;

public interface BillService {

	List<Bill> getBills();
	
	Bill getBill(int id);
	
	void saveBill(Bill bill);
	
	void updateBill(Bill bill);
	
	List<BillItem> getItemsOf(Bill bill);
	
	List<Status> getAllStatus();
}
