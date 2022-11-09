package com.swiggy.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.swiggy.app.Audit.Auditable;

@Entity
public class Offer extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String couponCode;
	private double minItemTotal;
	private double percentage;

	public Offer() {

	}

	public Offer(Long id, String couponCode, double minItemTotal, double percentage) {
		super();
		this.id = id;
		this.couponCode = couponCode;
		this.minItemTotal = minItemTotal;
		this.percentage = percentage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public double getMinItemTotal() {
		return minItemTotal;
	}

	public void setMinItemTotal(double minItemTotal) {
		this.minItemTotal = minItemTotal;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", couponCode=" + couponCode + ", minItemTotal=" + minItemTotal + ", percentage="
				+ percentage + "]";
	}

}
