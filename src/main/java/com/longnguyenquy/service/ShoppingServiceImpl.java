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
public class ShoppingServiceImpl implements ShoppingService {

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
	public void addItem(Item item) {
		
		User user = userService.currentUser();
		
		if(user.getCart() == null) {
			Cart cart = new Cart(user, new Date() ,new LinkedList<Item>());
			user.setCart(cart);
			cartDao.saveCart(cart);
		}
		
		Book book = bookDao.getBook(item.getBookId());	
		item.setBook(book);
		
		int newQuantity = book.getQuantity()-item.getQuantity();
		book.setQuantity(newQuantity);
		
		
		Cart cart = user.getCart();
		item.setCart(cart);
		cart.getItems().add(item);
		
		itemDao.saveItem(item);

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
	public void deleteItem(int itemId) {
		
		User user = userService.currentUser();
		
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
		
		return cartDao.getItemsOf(user.getCart());
	}

	
	@Override
	@Transactional
	public void buy() {
		
		User user = userService.currentUser();
		// Lấy ra list item
		Cart cart = user.getCart();
		
		List<Item> items = cart.getItems();
		
		// Tạo ra list bill item
		List<BillItem> billItems = new LinkedList<BillItem>();
		
		// Tạo ra bill 
		Bill bill = new Bill(user, new Date(),statusDao.getStatus(StatusType.PENDING));
				
		for(Item item: items) {
			// Ánh xạ item vào bill
			BillItem billItem = new BillItem(bill, item.getBook(), item.getBook().getPrice() , item.getQuantity());
			billItems.add(billItem);
			// Save bill item
			billItemDao.saveBillItem(billItem);
		}
		
		// Nạp list bill item vào bill
		bill.setBillItems(billItems);
		
		// Save bill
		billDao.saveBill(bill);
		
	}

}
