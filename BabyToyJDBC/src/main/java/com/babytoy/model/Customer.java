package com.babytoy.model;

import com.babytoy.exception.InvalidNameException;

public class Customer {
	private int customerId;
	private String customerName;
	private String password;
	private String city;
	private String state;
	private int zip;	
	private String country;
	
	public Customer() {
		
	}
	public Customer(int customerId, String customerName, String password, String city, String state, int zip,
			String country) throws InvalidNameException {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		if(customerName.length()<6) throw new InvalidNameException();
	}
	public Customer(String[] customerArray) {
		// TODO Auto-generated constructor stub
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) throws InvalidNameException  {
		this.customerName = customerName;
		if(customerName.length()<6) throw new InvalidNameException("Name should be minimum 6 characters");
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "customerId=" + customerId + ", customerName=" + customerName + ",  city=" + city + ", state=" + state + ", zip=" + zip + ", country=" + country + "]";
	}

}
