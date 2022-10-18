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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.swiggy.app.Audit.Auditable;

@Entity(name="Restaurant")
public class Restaurant extends Auditable<String>{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private double avgRating;
	private int totalRatings;
	
	@NotNull
	private String name;
	@NotNull
	private String address;
	
	@NotBlank(message="Type of restaurant shouldn't be blank")
	private String type;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="restaurant_id",referencedColumnName="id")
	private List<Category> categories=new ArrayList<>();
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="offer_id",referencedColumnName="id")
	private Offer offer;
	
	
	
	public Restaurant() {
		
	}

	public Restaurant(Long id, @NotNull String name, @NotNull String address, double avgRating,int totalRatings,
			@NotBlank(message = "Type of restaurant shouldn't be blank") String type, List<Category> categories,Offer offer) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.avgRating = avgRating;
		this.totalRatings=totalRatings;
		this.type = type;
		this.categories = categories;
		this.offer=offer;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int gettotalRatings() {
		return totalRatings;
	}

	public void settotalRatings(int totalRatings) {
		this.totalRatings = totalRatings;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public int getTotalRatings() {
		return totalRatings;
	}

	public void setTotalRatings(int totalRatings) {
		this.totalRatings = totalRatings;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + ", rating=" + avgRating + ", type="
				+ type + ", categories=" + categories + "]";
	}
	
	
	
	
}
