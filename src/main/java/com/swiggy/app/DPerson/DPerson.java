package com.swiggy.app.DPerson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DPerson {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String phoneNumber;
	private String estDelTime;
	private double rating;
	
	public DPerson() {
		super();
	}

	public DPerson(Long id, String name, String phoneNumber, String estDelTime, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.estDelTime = estDelTime;
		this.rating = rating;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getestDelTime() {
		return estDelTime;
	}

	public void setEstDelTime(String estDelTime) {
		this.estDelTime = estDelTime;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
		
}
