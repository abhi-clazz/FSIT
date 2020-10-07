package com.babytoy.service.Implementation;

import java.util.List;

import com.babytoy.DAO.CustomerDAO;
import com.babytoy.DAO.Implementation.CustomerDAOImpl;
import com.babytoy.exception.InvalidNameException;
import com.babytoy.model.Customer;
//import com.babytoy.model.Customer;
import com.babytoy.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	CustomerDAOImpl customerDAO=new CustomerDAOImpl();

	public void insert(Customer customer) throws InvalidNameException 
	{
		
		customerDAO.insert(customer);

	}

	public boolean search(int customerId) {

		return false;
	}

	public boolean search(String customerId) {
		
		return false;
	}

	public void display() {
		

	}

	public boolean delete(int customerId) {
		
		return false;
	}

	



}
