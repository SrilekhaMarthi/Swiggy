package com.swiggy.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.swiggy.app.Audit.Auditable;

@Entity
public class Item extends Auditable<String>{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	private String description;
	private int availability_status;
	private int quantity;
	private String image;
	//0=>not available 1=>available

	public Item() {
		
	}

	public Item(Long id, String name, double price, String description, int quantity,int availability_status,String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.availability_status = availability_status;
		this.image=image;
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAvailability_status() {
		return availability_status;
	}

	public void setAvailability_status(int availability_status) {
		this.availability_status = availability_status;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", availability_status=" + availability_status +  "]";
	}
	
	
	
}
