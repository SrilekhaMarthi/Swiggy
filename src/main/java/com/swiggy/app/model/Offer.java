package com.swiggy.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.swiggy.app.Audit.Auditable;

@Entity
public class Offer extends Auditable<String>{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String couponCode;//trynew
//	private double maxDiscount; //120
	private double minItemTotal; //149
	private double percentage; //60%=>60/100=>0.6
	// 1. 60 percent off on the purchases above 149.
	// 3. if 60% of total cart amount > 120,then only 120 rupees will be deducted.
	// 
	// 4. 60% of total cart amount => sum of 60% of each item for each quantity.
	
	//  offer.getpercentage => 
	//         nsum=0;
	//         nsum += (percentage*item.getPrice())*item.getquantity
	//  if (offer.getpercentage > 0.8*minItemTotal){
	//         nsum = (item.getPrice()*item.getquantity)-0.8*minItemTotal 
	// 5. maxDiscount => 80 percent of minItemTotal(120)
    /*
     * couponcode = trynew
     * minItemTotal = 149
     * percentage = 0.6
     * 
     * getSubTotal => sum(210);
     *  if (sum > minItemTotal){
     *       offerEnabled= true;
     *       if (offerEnabled){
     *         getSubTotal = getSubTotal - 
     * 
     * 
     * 
     * 
     */
	
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
				+ percentage +  "]";
	}
	
}
