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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart") 
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private int  limitCart;
	@OneToOne(mappedBy = "cart")
	private User user;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Cart_Items> items = new ArrayList<>();
	
	

	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Cart() {
		limitCart=5;
	}
	public Cart(int cartId,User user) {

		this.cartId = cartId;
		this.user=user;
	}
	public int getLimit() {
		return limitCart;
	}
	public void setLimit(int limit) {
		this.limitCart = limit;
	}
	public void add(Cart_Items c) {
		items.add(c);
	}
	
	
	
}
