package com.babytoy.model;

import com.babytoy.exception.InvalidAgeException;

public class Toy {
	private String toyId;
	private String toyName;
	private String toyType;
	private int minAge;
	private int maxAge;
	private float price;
	private int quantity;
	private float rentalAmount;
	public Toy(){
		
	}
	
	public Toy(String toyId, String toyName, String toyType, int minAge, int maxAge, float price, int quantity,
			float rentalAmount) throws InvalidAgeException{
		super();
		this.toyId = toyId;
		this.toyName = toyName;
		this.toyType = toyType;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.price = price;
		this.quantity = quantity;
		this.rentalAmount = rentalAmount;
		if(minAge<1&&maxAge>11) throw  new InvalidAgeException();

	}

	public String getToyId() {
		return toyId;
	}
	public void setToyId(String toyId) {
		this.toyId = toyId;
	}
	public String getToyName() {
		return toyName;
	}
	public void setToyName(String toyName) {
		this.toyName = toyName;
	}
	public String getToyType() {
		return toyType;
	}
	public void setToyType(String toyType) {
		this.toyType = toyType;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) throws InvalidAgeException {
		this.minAge = minAge;
		if(minAge<1) throw new InvalidAgeException();
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) throws InvalidAgeException {
		this.maxAge = maxAge;
		if(maxAge>11) throw new InvalidAgeException();
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getRentalAmount() {
		return rentalAmount;
	}
	public void setRentalAmount(float rentalAmount) {
		this.rentalAmount = rentalAmount;
	}

	@Override
	public String toString() {
		return "Toy [toyId=" + toyId + ", toyName=" + toyName + ", toyType=" + toyType + ", minAge=" + minAge
				+ ", maxAge=" + maxAge + ", price=" + price + ", quantity=" + quantity + ", rentalAmount="
				+ rentalAmount + "]";
	}

}
