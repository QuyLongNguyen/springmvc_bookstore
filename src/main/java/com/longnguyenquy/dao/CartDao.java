package com.longnguyenquy.dao;

import com.longnguyenquy.entity.Cart;
import com.longnguyenquy.entity.Item;

import java.util.*;
public interface CartDao {

	List<Cart> getCarts();
	
	Cart getCart(int cartId);
	
	List<Item> getItemsOf(Cart cart);
	
	void saveCart(Cart cart);
	
	void deleteCart(Cart cart);
	
}
