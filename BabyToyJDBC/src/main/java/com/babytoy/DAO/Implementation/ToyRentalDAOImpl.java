package com.babytoy.DAO.Implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.babytoy.DAO.DatabaseConnectionDAO;
import com.babytoy.DAO.ToyRentalDAO;
import com.babytoy.model.Customer;
import com.babytoy.model.ToyRental;

public class ToyRentalDAOImpl implements ToyRentalDAO {
	public void bookToy(ToyRental rental)
	{
		
		
		String bookQuery="INSERT INTO toy_Rental(Customer_Id,Toy_Id,Rental_Start_Date,Rental_End_Date,Rental_Amount_Per_Day, Total_Amount,Fine,Status)VALUES(?,?,?,?,?,?,?,?)";
		//Date start=new java.sql.Date(rental.getRentalStartDate().getTime());
		//Date end=new java.sql.Date(rental.getRentalEndDate().getTime());
		
		try 
		{
			PreparedStatement stat=DatabaseConnectionDAO.geConnection().prepareStatement(bookQuery,Statement.RETURN_GENERATED_KEYS);
			
			stat.setInt(1,rental.getCustomerId());
			stat.setInt(2,rental.getToyId());
			stat.setDate(3, new java.sql.Date(rental.getRentalStartDate().getTime()));
			stat.setDate(4, new java.sql.Date(rental.getRentalEndDate().getTime()));
			stat.setDouble(5, rental.getRentalAmountPerDay());
			stat.setDouble(6, rental.getTotalAmount());
			stat.setDouble(7, rental.getFine());
			stat.setString(8, rental.getStatus());
			stat.executeUpdate();
			ResultSet rs=stat.getGeneratedKeys();
			if(rs.next())
			{
				System.out.println(rs.getInt(1));
			}
				
			}
		
		catch (SQLIntegrityConstraintViolationException e)
		{
			e.printStackTrace();
			if(e.getMessage().contains("Duplicate entry"))
			System.out.println("duplicate");
		} 
		catch (SQLException e) 
		{
		System.out.println("");
		}
	}

	public double getRentalAmount(int customerId,int toyId,int rentalId) throws SQLException {
		String query="Select rental_amount_per_day from Toy_Rental where Customer_Id=? and toy_id=? and rental_id=?";
		double r = 0;
		PreparedStatement stat=DatabaseConnectionDAO.geConnection().prepareStatement(query);
		stat.setInt(1, customerId);
		stat.setInt(2, toyId);
		stat.setInt(3, rentalId);
		ResultSet rs=stat.executeQuery();
		if(rs.next())
		{
			r=rs.getFloat("rental_amount_per_day")*30;
		}
		else
		{
			System.out.println("No details found for entered fields");
		}

		
		return r;
	}

	@Override
	public void returnToy(int rentalId,int toyId,int customerId) throws SQLException {
		
		try {
		// TODO Auto-generated method stub
		String q="update toy_rental set status='returned' where rental_id=? and toy_id=?  where status='booked' and customerId=?";
		PreparedStatement stat=DatabaseConnectionDAO.geConnection().prepareStatement(q);
		stat.setInt(1, rentalId);
		stat.setInt(2, toyId);
		stat.setInt(3, customerId);
		
		int n=stat.executeUpdate();
		if(n>0)
		{
			System.out.println("toys returned");
			String query="update toy set quantity=quantity-1 where Toy_Id=?";
			PreparedStatement stat1=DatabaseConnectionDAO.geConnection().prepareStatement(query);
			stat1.setInt(1, toyId);
			stat1.execute();
		
		}
		else
		{
			System.out.println("No toys booked to return");
		}
		}
		catch (Exception e) {
			System.out.println("");		}

	}

	@Override
	public List<ToyRental> getRentalDetails(int CustomerId) {
		List<ToyRental>list=new ArrayList<ToyRental>();
		ToyRental tr=new ToyRental();
		// TODO Auto-generated method stub
		String query="Select customer_id,Toy_id,rentail_id,start_date,end_date,total_amount,fine,status from Toy_Rental where Customer_Id=?";
		
		try {
			PreparedStatement stat=DatabaseConnectionDAO.geConnection().prepareStatement(query);
			stat.setInt(1, CustomerId);
			ResultSet rs=stat.executeQuery();
			while(rs.next())
			{
				tr.setRentalId(rs.getInt("rental_id"));
				tr.setCustomerId(rs.getInt("customer_id"));
				tr.setToyId(rs.getInt("toy_id"));
				//tr.setFine(rs.getFloat("fine"));
				tr.setTotalAmount(rs.getDouble("total_amount"));
				tr.setStatus(rs.getString("status"));
				
				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return list ;
	}



	

	


	
}
