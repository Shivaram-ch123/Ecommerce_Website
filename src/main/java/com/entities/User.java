package com.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phonenumber;
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
	
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private List<Order> orders;
	
	

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public User(String name, String phonenumber,Cart cart) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
		this.cart=cart;
	}
	
	public User() {
	}
	public User(Cart cart) {
		super();
		this.cart = cart;
	
	}
		public Cart getCart() {
			return cart;
		}
		public void setCart(Cart cart) {
			this.cart = cart;
		}
	
	
	
	
	
}

