package com.babytoy.service.Implementation;

import java.sql.SQLException;
import java.util.List;

import com.babytoy.DAO.ToyRentalDAO;
import com.babytoy.DAO.Implementation.ToyRentalDAOImpl;
import com.babytoy.model.ToyRental;
import com.babytoy.service.ToyRentalService;

public class ToyRentalServiceImpl implements ToyRentalService {
	ToyRentalDAO toy=new ToyRentalDAOImpl();

	public void bookToy(ToyRental rental) {
		
		toy.bookToy(rental);
		
	}

	public  double getRentalAmount(int customerId,int toyId,int rentalId) throws SQLException{
		// TODO Auto-generated method stub
		double d=toy.getRentalAmount(customerId, toyId,rentalId);
		return d;
	}

	@Override
	public void  returnToy(int rentalId,int toyId,int customerId) throws SQLException  {
		toy.returnToy(rentalId, toyId,customerId);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ToyRental> getRentalDetails(int CustomerId) {
		// TODO Auto-generated method stub
		return toy.getRentalDetails(CustomerId);
	}



}
