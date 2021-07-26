package com.longnguyenquy.entity;

import javax.persistence.*;

@Entity
@Table(name = "bill_item")
public class BillItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_item_id")
	private int billItemId;
	
	@ManyToOne
	@JoinColumn(name = "bill_id")
	private Bill bill;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "quantity")
	private int quantity;
	
	public BillItem() {}

	public BillItem(Bill bill, Book book, long price, int quantity) {
		this.bill = bill;
		this.book = book;
		this.price = price;
		this.quantity = quantity;
	}
	public int getBillItemId() {
		return billItemId;
	}
	
	public void setBillItemId(int billItemId) {
		this.billItemId = billItemId;
	}
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	};
	
	

}
