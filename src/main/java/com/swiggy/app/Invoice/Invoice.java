package com.swiggy.app.Invoice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invoice {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double cartSubTotal;
	private double gst;
	private double deliveryCharges;
	private String link;
	
	public Invoice() {
		super();
	}

	public Invoice(Long id, double cartSubTotal, double gst, double deliveryCharges, String link) {
		super();
		this.id = id;
		this.cartSubTotal = cartSubTotal;
		this.gst = gst;
		this.deliveryCharges = deliveryCharges;
		this.link = link;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCartSubTotal() {
		return cartSubTotal;
	}

	public void setCartSubTotal(double cartSubTotal) {
		this.cartSubTotal = cartSubTotal;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public double getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
