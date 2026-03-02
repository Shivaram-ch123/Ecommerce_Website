package com.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int orderId;
	@ManyToOne
	private User userId;
	
	//@OneToMany
	//private List<Order_Product> listOfOrders = new ArrayList<>();
	

	

	public int getOrderId() {
		return orderId;
	}
	
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Order_Product> orderProducts;
	
	
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Order(User userId) {
		super();

		this.userId = userId;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
