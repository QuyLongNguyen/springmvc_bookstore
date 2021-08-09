package com.longnguyenquy.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.longnguyenquy.dao.BillDao;
import com.longnguyenquy.dao.BillItemDao;
import com.longnguyenquy.dao.BookDao;
import com.longnguyenquy.dao.CartDao;
import com.longnguyenquy.dao.ItemDao;
import com.longnguyenquy.dao.StatusDao;
import com.longnguyenquy.dto.StatusType;
import com.longnguyenquy.entity.Bill;
import com.longnguyenquy.entity.BillItem;
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
	BookDao bookDao;
	
	
	@Autowired
	BillDao billDao;
	
	@Autowired
	BillItemDao billItemDao;
	
	@Autowired
	StatusDao statusDao;
	
	@Autowired
	UserService userService;
	
	@Override
	@Transactional
	public Cart getCart(int cartId) {
		return cartDao.getCart(cartId);
	}
	
	@Override
	@Transactional
	public List<Cart> getCarts(){
		return cartDao.getCarts();
	}
	
	@Override
	@Transactional
	public void createCart(String username) {
		User user = userService.findByUserName(username);
		Cart cart = user.getCart();
		cart =  new Cart(user, new Date() ,new LinkedList<Item>());
		cartDao.saveCart(cart);
	}
	
	@Override
	@Transactional
	public void addItem(Item item) {
		
		User user = userService.currentUser();
		Cart cart = user.getCart();
		
		List<Item> items = cart.getItems();
		boolean isDuplicateItem = false;
	
		for(Item i: items ) {
			if(i.getBook().getBookId() == item.getBookId()) {
				i.setQuantity(i.getQuantity()+item.getQuantity());
				isDuplicateItem = true;
				break;
			}
		}
		Book book = bookDao.getBook(item.getBookId());
		
		if(!isDuplicateItem) {
			item.setBook(book);
			item.setCart(cart);
			items.add(item);
			itemDao.saveItem(item);
		}
		
		book.setQuantity(book.getQuantity()-item.getQuantity());
			
	}
	
	
	@Override
	@Transactional
	public void updateItem(int itemId, int quantity) {
		
		User user = userService.currentUser();
		
		Cart cart = user.getCart();
		
		List<Item> items = cart.getItems();
		
		Item item = itemDao.getItem(itemId);
		
		if(items.contains(item)) {
			
			Book book = bookDao.getBook(item.getBook().getBookId());
			int newQuantity = book.getQuantity() + item.getQuantity() - quantity;
			book.setQuantity(newQuantity);
			
			item.setQuantity(quantity);
			itemDao.saveItem(item);
		}	
	}

	@Override
	@Transactional
	public void deleteItem(long userId, int itemId) {
		
		User user = userService.getUser(userId);
		
		Cart cart = user.getCart();
		
		List<Item> items = cart.getItems();

		Item item = itemDao.getItem(itemId);
		
		if(items.contains(item)) {
			
			Book book = bookDao.getBook(item.getBook().getBookId());
			int newQuantity = book.getQuantity() + item.getQuantity();
			book.setQuantity(newQuantity);
			
			items.remove(item);
			
			itemDao.deleteItem(item);
		}	
	}

	@Override
	@Transactional
	public List<Item> getCartItems() {
	
		User user = userService.currentUser();
		if(user != null && user.getCart() != null) {
			return cartDao.getItemsOf(user.getCart());
		}
		return null;
		
	}

	@Override
	@Transactional
	public List<Item> getCartItemsOf(int cartId) {
	
		Cart cart = cartDao.getCart(cartId);
		
		return cartDao.getItemsOf(cart);
		
	}
	
	@Override
	@Transactional
	public void buy() {
		
		User user = userService.currentUser();
		
		Cart cart = user.getCart();
		
		List<Item> items = cart.getItems();
		
		
		List<BillItem> billItems = new LinkedList<BillItem>();
		
	
		Bill bill = new Bill(user, new Date(),statusDao.getStatus(StatusType.PENDING));
				
		for(Item item: items) {
			
			BillItem billItem = new BillItem(bill, item.getBook(), item.getBook().getPrice(),item.getQuantity());
			billItems.add(billItem);
			
			billItemDao.saveBillItem(billItem);
		}
		
		
		bill.setBillItems(billItems);
		
		billDao.saveBill(bill);
			
		itemDao.deleteItemsOf(cart);
		
		cartDao.deleteCart(cart);
		
	}

}
