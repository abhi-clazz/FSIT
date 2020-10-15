package com.babytoy.service;

import java.sql.SQLException;
import java.util.List;

import com.babytoy.model.ToyRental;

public interface ToyRentalService {
	
	public void bookToy(ToyRental rental);
	public double getRentalAmount(int customerId,int toyId,int rentalId) throws SQLException;
	//public boolean returnToy(int toyId);
	public void returnToy(int rentalId, int toyId,int customerId) throws SQLException;
	
	public List<ToyRental> getRentalDetails(int CustomerId);


}
