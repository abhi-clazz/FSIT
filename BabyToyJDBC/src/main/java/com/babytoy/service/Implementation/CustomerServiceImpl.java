package com.babytoy.service.Implementation;

import java.util.List;

import com.babytoy.DAO.Implementation.CustomerDAOImpl;
import com.babytoy.exception.InvalidNameException;
import com.babytoy.model.Customer;
import com.babytoy.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	CustomerDAOImpl customerDAO=new CustomerDAOImpl();

	public void insert(Customer customer) throws InvalidNameException 
	{
		customerDAO.insert(customer);
	}

	public boolean search(int customerId) {
		boolean b=customerDAO.search(customerId);
		return b;
	}

	public boolean search(String customerName)
	{
		boolean b=customerDAO.search(customerName);
		return b;
	}
	public void delete(int customerId) 
	{
		customerDAO.delete(customerId);
	}

	public List<Customer>display()  {
		customerDAO.display();
		return customerDAO.display();
	}

	public boolean update(int customerId,String c)
	{
		boolean b=customerDAO.update(customerId,c);
		return b;
		
	}

	@Override
	public boolean login(int id, String p) {
		// TODO Auto-generated method stub
		boolean b=customerDAO.login(id,p);
		return b;
	}



}
