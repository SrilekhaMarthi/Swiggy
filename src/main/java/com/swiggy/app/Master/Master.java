package com.swiggy.app.Master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.databind.JsonNode;


@Entity
public class Master implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long restuarantId;
	private String restuarantName;
	private String restuarantLocation;
	
	private Long userId;
	private String userName;
	private String userAddress;
	private String userMail;
	private String userPhone;
	
	@Column(length=500)
	@Type(type="com.vladmihalcea.hibernate.type.json.JsonBinaryType")
	private JsonNode items;
	
	private Long cartId;
	private double cartSubTotal;
	private double gst;
	private double deliveryCharges;
	
	private String estDelTime;
	
	private Long personId;
	private String personName;
	private String personPhone;
	
	private Long paymentId;
	private String paymentMode;
	private String paymentStatus;
	private String transactionId;
	private String invoiceLink;
	
	private String orderStatus;

	public Master() {
		super();
	}

	public Master( Long restuarantId, String restuarantName, String restuarantLocation, Long userId,
			String userName, String userAddress, String userMail, String userPhone, JsonNode items, Long cartId, double cartSubTotal, double gst, double deliveryCharges, String estDelTime,
			Long personId, String personName, String personPhone, Long paymentId,String paymentMode, String paymentStatus,
			String transactionId, String invoiceLink, String orderStatus) {
		super();
		this.restuarantId = restuarantId;
		this.restuarantName = restuarantName;
		this.restuarantLocation = restuarantLocation;
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userMail = userMail;
		this.userPhone = userPhone;
		this.items = items;
		this.cartId = cartId;
		this.cartSubTotal = cartSubTotal;
		this.gst = gst;
		this.deliveryCharges = deliveryCharges;
		this.estDelTime = estDelTime;
		this.personId = personId;
		this.personName = personName;
		this.personPhone = personPhone;
		this.paymentId=paymentId;
		this.paymentMode = paymentMode;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.invoiceLink = invoiceLink;
		this.orderStatus = orderStatus;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRestuarantId() {
		return restuarantId;
	}

	public void setRestuarantId(Long restuarantId) {
		this.restuarantId = restuarantId;
	}

	public String getRestuarantName() {
		return restuarantName;
	}

	public void setRestuarantName(String restuarantName) {
		this.restuarantName = restuarantName;
	}

	public String getRestuarantLocation() {
		return restuarantLocation;
	}

	public void setRestuarantLocation(String restuarantLocation) {
		this.restuarantLocation = restuarantLocation;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	public JsonNode getItems() {
		return items;
	}

	public void setItems(JsonNode items) {
		this.items = items;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
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

	public String getEstDelTime() {
		return estDelTime;
	}

	public void setEstDelTime(String estDelTime) {
		this.estDelTime = estDelTime;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	
	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getInvoiceLink() {
		return invoiceLink;
	}

	public void setInvoiceLink(String invoiceLink) {
		this.invoiceLink = invoiceLink;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", restuarantName=" + restuarantName + ", restuarantLocation=" + restuarantLocation
				+ ", userName=" + userName + ", userAddress=" + userAddress + ", userMail=" + userMail + ", userPhone="
				+ userPhone + ", items=" + items + ", cartId=" + cartId + ", cartSubTotal=" + cartSubTotal + ", gst="
				+ gst + ", deliveryCharges=" + deliveryCharges + ", estDelTime=" + estDelTime + ", personName="
				+ personName + ", personPhone=" + personPhone + ", paymentMode=" + paymentMode + ", paymentStatus="
				+ paymentStatus + ", transactionId=" + transactionId + ", invoiceLink=" + invoiceLink + ", orderStatus="
				+ orderStatus + "}";
	}
	
	
	
}
