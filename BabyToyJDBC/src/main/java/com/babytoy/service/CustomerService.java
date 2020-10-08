package com.babytoy.service;

import java.util.List;
import com.babytoy.exception.InvalidNameException;
import com.babytoy.model.Customer;

public interface CustomerService
{
	public  void insert(Customer customer) throws InvalidNameException;
	
	public List<Customer> display() ;
	

	public boolean search(int customerId);

	public boolean search(String customerName);

	
	public void delete(int customerId);

}