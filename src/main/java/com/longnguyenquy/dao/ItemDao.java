package com.longnguyenquy.dao;

import com.longnguyenquy.entity.Cart;
import com.longnguyenquy.entity.Item;

public interface ItemDao {

	Item getItem(int id);
	
	void saveItem(Item item);
	
	void deleteItem(Item item);
	
	void deleteItemsOf(Cart cart);
}
