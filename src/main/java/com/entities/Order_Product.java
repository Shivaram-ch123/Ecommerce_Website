package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Order_Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
	
	private String address;
	private int totalCost;
	private int daysToDeliver;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Order getOrderId() {
		return order;
	}
	public void setOrderId(Order orderId) {
		this.order = orderId;
	}
	public Product getProductId() {
		return product;
	}
	public void setProductId(Product productId) {
		this.product = productId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public int getDaysToDeliver() {
		return daysToDeliver;
	}
	public void setDaysToDeliver(int daysToDeliver) {
		this.daysToDeliver = daysToDeliver;
	}
	public Order_Product(Order orderId, Product productId, String address, int totalCost, int daysToDeliver) {
		super();
		this.order = orderId;
		this.product = productId;
		this.address = address;
		this.totalCost = totalCost;
		this.daysToDeliver = daysToDeliver;
	}
	public Order_Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
