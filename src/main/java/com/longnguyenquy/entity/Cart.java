package com.longnguyenquy.entity;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int cartId;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "cart")
	private List<Item> items;
	
	public Cart() {}
	
	public Cart(User user,List<Item> items) {
		this.user = user;
		this.items = items;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int orderId) {
		this.cartId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
}
