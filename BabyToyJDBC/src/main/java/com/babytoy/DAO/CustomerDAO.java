package com.babytoy.DAO;

import com.babytoy.exception.InvalidNameException;
import com.babytoy.model.Customer;

public interface CustomerDAO {


	public void insert(Customer customer) throws InvalidNameException;

	

}
