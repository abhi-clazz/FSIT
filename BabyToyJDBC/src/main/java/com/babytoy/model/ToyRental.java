package com.babytoy.model;

import java.util.Date;

public class ToyRental {
	
	private int rentalId;
	private int customerId;
	private int toyId;
	private Date rentalStartDate;
	private Date rentalEndDate;
	private Double totalAmount;
	private Double fine;
	private String status;
	
	public ToyRental() {
		
	}
	
	public ToyRental(int rentalId, int customerId, int toyId, Date rentalStartDate, Date rentalEndDate,
			Double totalAmount, Double fine, String status) {
		super();
		this.rentalId = rentalId;
		this.customerId = customerId;
		this.toyId = toyId;
		this.rentalStartDate = rentalStartDate;
		this.rentalEndDate = rentalEndDate;
		this.totalAmount = totalAmount;
		this.fine = fine;
		this.status = status;
	}
	public int getRentalId() {
		return rentalId;
	}
	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getToyId() {
		return toyId;
	}
	public void setToyId(int toyId) {
		this.toyId = toyId;
	}
	public Date getRentalStartDate() {
		return rentalStartDate;
	}
	public void setRentalStartDate(Date rentalStartDate) {
		this.rentalStartDate = rentalStartDate;
	}
	public Date getRentalEndDate() {
		return rentalEndDate;
	}
	public void setRentalEndDate(Date rentalEndDate) {
		this.rentalEndDate = rentalEndDate;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getFine() {
		return fine;
	}
	public void setFine(Double fine) {
		this.fine = fine;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ToyRental [rentalId=" + rentalId + ", customerId=" + customerId + ", toyId=" + toyId
				+ ", rentalStartDate=" + rentalStartDate + ", rentalEndDate=" + rentalEndDate + ", totalAmount="
				+ totalAmount + ", fine=" + fine + ", status=" + status + "]";
	}

}
