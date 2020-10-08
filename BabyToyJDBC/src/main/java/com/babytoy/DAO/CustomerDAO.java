package com.babytoy.DAO;

import java.util.List;

import com.babytoy.exception.InvalidNameException;
import com.babytoy.model.Customer;

public interface CustomerDAO {


	public void insert(Customer customer) throws InvalidNameException;
	public List<Customer> display() ;
	public void delete(int customerId);


	

}
