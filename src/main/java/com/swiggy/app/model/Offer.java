package com.swiggy.app.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date fromDate;
	private Time fromTime;
	private Date toDate;
	private Time toTime;
	
	public Offer() {
		
	}
	
	
	public Offer(Long id, Date fromDate, Time fromTime, Date toDate, Time toTime) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.fromTime = fromTime;
		this.toDate = toDate;
		this.toTime = toTime;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Time getFromTime() {
		return fromTime;
	}
	public void setFromTime(Time fromTime) {
		this.fromTime = fromTime;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Time getToTime() {
		return toTime;
	}
	public void setToTime(Time toTime) {
		this.toTime = toTime;
	}


	@Override
	public String toString() {
		return "Offer [id=" + id + ", fromDate=" + fromDate + ", fromTime=" + fromTime + ", toDate=" + toDate
				+ ", toTime=" + toTime + "]";
	}
	
	
	
}
