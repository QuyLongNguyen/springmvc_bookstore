package com.longnguyenquy.dao;

import com.longnguyenquy.entity.Item;

public interface CartDao {

	void addItem(Item item);
		
	void deleteItem(Item item);
}
