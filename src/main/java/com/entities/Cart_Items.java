package com.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Cart_Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Cart cart; //creates a col
	
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	
	
	
	private int count;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public Cart_Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Cart_Items(Cart cart, Product product, int count) {
		super();
		this.cart = cart;
		this.product = product;
		this.count = count;
	}
	
	
	
}
