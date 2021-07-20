package com.longnguyenquy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.longnguyenquy.dao.CartDao;
import com.longnguyenquy.entity.Item;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;
	
	@Override
	@Transactional
	public void addItem(Item item) {
		
		cartDao.addItem(item);

	}

	@Override
	@Transactional
	public void deleteItem(Item item) {
		
		cartDao.deleteItem(item);
	}

}
