package com.babytoy.DAO.Implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.babytoy.DAO.DatabaseConnectionDAO;
import com.babytoy.DAO.ToyDAO;
import com.babytoy.exception.InvalidAgeException;
import com.babytoy.model.Toy;

public class ToyDAOImpl implements ToyDAO {

	public void insertToys(Toy toy) {

		String insertQuery="INSERT INTO Toy(Toy_Name,Toy_Type,Min_Age,Max_age,Price,Quantity,Rental_Amount)VALUES(?,?,?,?,?,?,?)";
		try 
		{
				PreparedStatement preparedStatement=DatabaseConnectionDAO.geConnection().prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
				
				preparedStatement.setString(1, toy.getToyName());
				preparedStatement.setString(2, toy.getToyType());
				preparedStatement.setInt(3, toy.getMinAge());
				preparedStatement.setInt(4, toy.getMaxAge());
				preparedStatement.setFloat(5, toy.getPrice());
				preparedStatement.setInt(6, toy.getQuantity());
				preparedStatement.setFloat(7, toy.getRentalAmount());
				preparedStatement.executeUpdate();
				
				ResultSet rs=preparedStatement.getGeneratedKeys();
				if(rs.next())
				System.out.println("registration is succesfful with toyid: "+rs.getInt(1));
			
		}
		catch (SQLIntegrityConstraintViolationException e)
		{
			if(e.getMessage().contains("Duplicate entry"))
				System.out.println("duplicate");
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
	}
	@Override
	public List<Toy> getToys() throws InvalidAgeException  {
		// TODO Auto-generated method stub
		List<Toy>toylist1=new ArrayList<Toy>();
		String query="SELECT toy_id,toy_name,toy_type,min_age,max_age,price,rental_amount,quantity FROM TOY";
		try {
			PreparedStatement stat=DatabaseConnectionDAO.geConnection().prepareStatement(query);
			ResultSet rs=stat.executeQuery();
			while(rs.next())
			{
				Toy t=new Toy();
				t.setToyId(rs.getInt("toy_id"));
				t.setToyName(rs.getString("toy_name"));
				t.setMinAge(rs.getInt("min_age"));
				t.setMaxAge(rs.getInt("max_age"));
				t.setPrice(rs.getFloat("price"));
				t.setQuantity(rs.getInt("quantity"));
				t.setRentalAmount(rs.getFloat("rental_Amount"));
				t.setToyType(rs.getString("toy_type"));
				toylist1.add(t);
				
			}
			System.out.println(toylist1);
		}
		catch (Exception e) 
		{
			}
		return toylist1;
	}

	@Override
	public List<Toy> searchToy(int toyid) {
		// TODO Auto-generated method stub
		List<Toy>toylist=new ArrayList<Toy>();
		String query="Select Toy_id,Toy_name,toy_type,min_age,max_age,price,rental_amount,quantity from Toy where toy_id=?";
		try {
			PreparedStatement stat=DatabaseConnectionDAO.geConnection().prepareStatement(query);
			stat.setInt(1, toyid);
			ResultSet rs=stat.executeQuery();
			Toy t=new Toy();
			while(rs.next())
			{
				t.setToyId(rs.getInt("toy_id"));
				t.setToyName(rs.getString("toy_name"));
				t.setMinAge(rs.getInt("min_age"));
				t.setMaxAge(rs.getInt("max_age"));
				t.setPrice(rs.getFloat("price"));
				t.setQuantity(rs.getInt("quantity"));
				t.setToyType(rs.getString("toy_type"));
				t.setRentalAmount(rs.getFloat("rental_Amount"));
				toylist.add(t);
			}
		}
		catch (Exception e) {
	}
		return toylist;
	}
	
	@Override
	public boolean updateToy(int toyid,Toy t) {
		try {
			String q = "update toy set ";
			if(!(t.getToyName().equalsIgnoreCase("0"))) {
				q += "toy_name='"+t.getToyName()+"', ";
			}
			if(!(t.getToyType().equalsIgnoreCase("0"))) {
				q += "toy_type='"+t.getToyType()+"', ";
			}
			if(t.getMinAge() != 0) {
				q += "minage='"+t.getMinAge()+"', ";
			}
			if(t.getMaxAge() != 0) {
				q += "maxage='"+t.getMaxAge()+"', ";
			}
			if(t.getPrice() != 0) {
				q += "price="+t.getPrice()+", ";
			}
			if(t.getQuantity() != 0) {
				q += "quantity="+t.getQuantity()+", ";
			}		
			if(t.getRentalAmount() != 0){
				q += "rental_amount='"+t.getRentalAmount()+"', ";
			}
			String query = q.substring(0, q.length() - 2);
			query += " where toy_id="+toyid;
			PreparedStatement preparedStatement=DatabaseConnectionDAO.geConnection().prepareStatement(query);
		
			int r=preparedStatement.executeUpdate();
			
			if(r>0)
			{
				System.out.println("updated");
			}
			else {
				System.out.println("enter valid toyId");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deleteToy(int toyid) {
		boolean b = false;
		String query="Delete from Toy where Toy_id=?";
		try {
			PreparedStatement stat=DatabaseConnectionDAO.geConnection().prepareStatement(query);
			stat.setInt(1, toyid);
			b=stat.execute();
			if(b)
			System.out.println("Deleted Toy");
			else
			{
				System.out.println("Enter valid toyId ");
			}
		}
		
		catch(SQLIntegrityConstraintViolationException e)
		{
		System.out.println("Cant delete toys which are already booked by customer.Please delete after return peroid");
		}
		catch (Exception e) {
			
		}
		return b;
	}
	@Override
	public void toyRentDetails(int toyid) {
		List<Toy>toylist=new ArrayList<Toy>();
		String query="Select Toy_id,toy_type,Toy_name,min_age,max_age,price,rental_amount,quantity from Toy where toy_id=?";
		try {
			PreparedStatement stat=DatabaseConnectionDAO.geConnection().prepareStatement(query);
			stat.setInt(1, toyid);
			ResultSet rs=stat.executeQuery();
			Toy t=new Toy();
			if(rs.next())
			{
				t.setToyId(rs.getInt("toy_id"));
				t.setToyType(rs.getString("toy_type"));
				t.setToyName(rs.getString("toy_name"));
				t.setMinAge(rs.getInt("min_age"));
				t.setMaxAge(rs.getInt("max_age"));
				t.setPrice(rs.getFloat("price"));
				t.setQuantity(rs.getInt("quantity"));
				t.setRentalAmount(rs.getFloat("rental_Amount"));
				toylist.add(t);
				System.out.println(toylist);
			}
			
			else {
				System.out.println("no toy found");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
