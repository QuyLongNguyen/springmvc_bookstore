package com.longnguyenquy.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.longnguyenquy.dao.BookDao;
import com.longnguyenquy.dao.CartDao;
import com.longnguyenquy.dao.ItemDao;
import com.longnguyenquy.dao.UserDao;
import com.longnguyenquy.dto.AuthenticationDto;
import com.longnguyenquy.entity.Book;
import com.longnguyenquy.entity.Cart;
import com.longnguyenquy.entity.Item;
import com.longnguyenquy.entity.User;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;
	
	@Autowired
	ItemDao itemDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	BookDao bookDao;
	
	@Override
	@Transactional
	public void addItem(Item item) {
		
		User user = userDao.findByUserName(AuthenticationDto.getAuthentication().getName());
		
		if(user.getCart() == null) {
			Cart cart = new Cart(user, new java.util.Date() ,new LinkedList<Item>());
			user.setCart(cart);
			cartDao.saveCart(cart);
		}
		
		Book book = bookDao.getBook(item.getBookId());	
		item.setBook(book);
		
		Cart cart = user.getCart();
		item.setCart(cart);
		cart.getItems().add(item);
	
		itemDao.saveItem(item);

	}
	@Override
	@Transactional
	public void updateItem(int itemId, int quantity) {
		
		User user = userDao.findByUserName(AuthenticationDto.getAuthentication().getName());
		
		Cart cart = user.getCart();
		
		List<Item> items = cart.getItems();
		
		Item item = itemDao.getItem(itemId);
		
		if(items.contains(item)) {
			item.setQuantity(quantity);
			itemDao.saveItem(item);
		}	
	}

	@Override
	@Transactional
	public void deleteItem(int itemId) {
		
		User user = userDao.findByUserName(AuthenticationDto.getAuthentication().getName());
		
		Cart cart = user.getCart();
		
		List<Item> items = cart.getItems();

		Item item = itemDao.getItem(itemId);
		
		if(items.contains(item)) {
			items.remove(item);
			itemDao.deleteItem(item);
		}	
	}

	@Override
	@Transactional
	public List<Item> getCartItems() {
		
		User user = userDao.findByUserName(AuthenticationDto.getAuthentication().getName());
		
		return cartDao.getItemsOf(user.getCart());
	}

	


}
