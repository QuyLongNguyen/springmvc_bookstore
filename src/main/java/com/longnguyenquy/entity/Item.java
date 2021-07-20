package com.longnguyenquy.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemId;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Transient
	private int bookId;
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Item() {
		super();
	}

	public Item(Book book, Cart cart,int quantity) {
		super();
		this.book = book;
		this.cart = cart;
		this.quantity = quantity;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", book=" + book + ", cart=" + cart + ", quantity=" + quantity + ", bookId="
				+ bookId + "]";
	}
	
}
