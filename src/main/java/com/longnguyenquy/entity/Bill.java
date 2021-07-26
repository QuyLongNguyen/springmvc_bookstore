package com.longnguyenquy.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "bill")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_id")
	private int billId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;

	@OneToMany(mappedBy = "bill")
	private List<BillItem> billItems;
	
	public Bill() {
		super();
		
	}

	public Bill(User user, Date dateCreated, Status status) {
		super();
		this.user = user;
		this.dateCreated = dateCreated;
		this.status = status;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<BillItem> getBillItems() {
		return billItems;
	}

	public void setBillItems(List<BillItem> billItems) {
		this.billItems = billItems;
	}
	
	
	
	
}
