package com.longnguyenquy.service;

import java.util.List;

import com.longnguyenquy.entity.Item;


public interface ShoppingService {
	
	List<Item> getCartItems();
	
	void addItem(Item item);
	
	void buy();
	
	void updateItem(int itemId, int quantity);
		
	void deleteItem(int itemId);
}
