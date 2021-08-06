package com.longnguyenquy.service;

import java.math.BigDecimal;
import java.util.List;

import com.longnguyenquy.entity.Bill;
import com.longnguyenquy.entity.BillItem;
import com.longnguyenquy.entity.Status;

public interface BillService {

	List<Bill> getBills();
	
	List<Bill> getBillsOfCurentUser();
	
	Bill getBill(int id);
	
	List<BillItem> getItemsOf(Bill bill);
	
	List<Status> getAllStatus();
	
	BigDecimal getTotalPrice(Bill bill);
	
	void saveBill(Bill bill);
	
	void updateBill(Bill bill);
	
	void deleteBill(int id);
	
	
}
