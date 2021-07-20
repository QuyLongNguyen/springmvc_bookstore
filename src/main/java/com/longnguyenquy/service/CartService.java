package com.longnguyenquy.service;

import com.longnguyenquy.entity.Item;

public interface CartService {
	void addItem(Item item);
	
	void deleteItem(Item item);
}
