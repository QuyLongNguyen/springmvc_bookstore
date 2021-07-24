package com.longnguyenquy.service;

import java.util.List;

import com.longnguyenquy.entity.Cart;
import com.longnguyenquy.entity.Item;
import com.longnguyenquy.entity.User;

public interface CartService {
	
	List<Item> getCartItems();
	
	void addItem(Item item);
	
	void updateItem(int itemId, int quantity);
		
	void deleteItem(int itemId);
}
