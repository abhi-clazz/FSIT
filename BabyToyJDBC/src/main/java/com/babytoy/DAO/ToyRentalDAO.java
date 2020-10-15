package com.babytoy.DAO;

import java.sql.SQLException;
import java.util.List;

import com.babytoy.model.Toy;
import com.babytoy.model.ToyRental;

public interface ToyRentalDAO {
	public void bookToy(ToyRental rental);

	public double getRentalAmount(int customerId,int toyId,int rentalId) throws SQLException;
	public List<ToyRental> getRentalDetails(int CustomerId);

	public void returnToy(int rentalId, int toyId,int customerId) throws SQLException;

	



	

}
