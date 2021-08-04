package com.longnguyenquy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.longnguyenquy.dao.BillDao;
import com.longnguyenquy.dao.StatusDao;
import com.longnguyenquy.entity.Bill;
import com.longnguyenquy.entity.BillItem;
import com.longnguyenquy.entity.Status;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	BillDao billDao;
	
	@Autowired
	StatusDao statusDao;
	
	@Autowired
	UserService userService;
	
	@Override
	@Transactional
	public List<Bill> getBills() {
		
		return billDao.getBills();
	}

	@Override
	@Transactional
	public List<Bill> getBillsOfCurentUser(){
		
		return billDao.getBills(userService.currentUser().getId());
	}
	
	@Override
	@Transactional
	public Bill getBill(int id) {
	
		return billDao.getBill(id);
	}

	@Override
	@Transactional
	public void saveBill(Bill bill) {
		
		billDao.saveBill(bill);

	}
	
	@Override
	@Transactional
	public void updateBill(Bill bill) {
		
		Status status = statusDao.getStatus(bill.getStatusId());
		
		bill.setStatus(status);
		
		billDao.saveBill(bill);
		
	}
	
	@Override
	@Transactional
	public List<BillItem> getItemsOf(Bill bill){
		
		return billDao.getItemsOf(bill);
	}
	
	@Override
	@Transactional
	public List<Status> getAllStatus(){
		
		return statusDao.getAllStatus();
	}
	

}
