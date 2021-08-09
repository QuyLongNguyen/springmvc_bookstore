package com.longnguyenquy.service;

import java.util.List;

import com.longnguyenquy.entity.Cart;
import com.longnguyenquy.entity.Item;


public interface CartService {
	
	Cart getCart(int cartId);
	
	List<Cart> getCarts();
	
	List<Item> getCartItems();
	
	List<Item> getCartItemsOf(int cartId);
	
	void createCart(String username);
	
	void addItem(Item item);
	
	void updateItem(int itemId, int quantity);
		
	void deleteItem(long userId, int itemId);
	
	void buy();
}
