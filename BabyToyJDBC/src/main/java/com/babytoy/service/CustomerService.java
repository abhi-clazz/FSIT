package com.babytoy.service;

import com.babytoy.exception.InvalidNameException;
import com.babytoy.model.Customer;

public interface CustomerService
{
	public  void insert(Customer customer) throws InvalidNameException;

	public boolean search(int customerId);

	public boolean search(String customerId);

	public void display();
	
	public boolean delete(int customerId);

}