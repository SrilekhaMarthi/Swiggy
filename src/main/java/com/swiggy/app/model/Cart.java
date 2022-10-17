package com.swiggy.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.swiggy.app.Audit.Auditable;

@Entity
public class Cart extends Auditable<String>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private Long restaurantId;
	private double subTotal;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cart_id",referencedColumnName="id")
	private List<Item> items=new ArrayList<>();
	
	@Transient
	private Item item;
	
	
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Cart() {
		
	}
	public Cart(Long id,Long userId,double subTotal) {
		super();
		this.id = id;
		this.userId=userId;
		this.subTotal=subTotal;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	@Override
	public String toString() {
		return "id=" + id + ", userId=" + userId + ", subTotal=" + subTotal + "";
	}
	
}
