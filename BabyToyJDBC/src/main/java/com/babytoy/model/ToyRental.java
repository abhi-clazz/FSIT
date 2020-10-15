package com.babytoy.model;

import java.util.Date;

public class ToyRental {
	
	private int rentalId;
	private int customerId;
	private int toyId;
	private Date rentalStartDate;
	private Date rentalEndDate;
	private double totalAmount;
	private double fine;
	private String status;
	private double rentalAmountPerDay;
	


public ToyRental() {
		
	}
	
	
	public ToyRental(int rentalId, int customerId, int toyId, Date rentalStartDate, Date rentalEndDate,
			double totalAmount, double fine, String status, double rentalAmountPerDay) {
		super();
		this.rentalId = rentalId;
		this.customerId = customerId;
		this.toyId = toyId;
		this.rentalStartDate = rentalStartDate;
		this.rentalEndDate = rentalEndDate;
		this.totalAmount = totalAmount;
		this.fine = fine;
		this.status = status;
		this.rentalAmountPerDay = rentalAmountPerDay;
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
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getRentalAmountPerDay() {
		return rentalAmountPerDay;
	}


	public void setRentalAmountPerDay(double rentalAmountPerDay) {
		this.rentalAmountPerDay = rentalAmountPerDay;
	}


	@Override
	public String toString() {
		return "ToyRental [rentalId=" + rentalId + ", customerId=" + customerId + ", toyId=" + toyId + ", totalAmount="
				+ totalAmount + ", status=" + status + "]";
	}




}
