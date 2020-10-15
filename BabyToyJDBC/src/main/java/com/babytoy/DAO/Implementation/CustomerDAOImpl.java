package com.babytoy.DAO.Implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.babytoy.DAO.CustomerDAO;
import com.babytoy.DAO.DatabaseConnectionDAO;
import com.babytoy.exception.InvalidNameException;
import com.babytoy.model.Customer;

public class CustomerDAOImpl implements CustomerDAO 
{

	public void insert(Customer customer) throws InvalidNameException 
	{
		String insertQuery="INSERT INTO Customer(Customer_Name,Password,State,City,ZIP,Country)VALUES(?,?,?,?,?,?)";
		try 
		{
		
				PreparedStatement preparedStatement=DatabaseConnectionDAO.geConnection().prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
				//preparedStatement.setInt(1, customer.getCustomerId());
				preparedStatement.setString(1, customer.getCustomerName());
				preparedStatement.setString(2, customer.getPassword());
				preparedStatement.setString(3, customer.getState());
				preparedStatement.setString(4, customer.getCity());
				preparedStatement.setInt(5, customer.getZip());
				preparedStatement.setString(6, customer.getCountry());
				preparedStatement.executeUpdate();
				ResultSet rs=preparedStatement.getGeneratedKeys();
				if(rs.next())
				System.out.println("Hello " +customer.getCustomerName() +" registration is succesfful with customerId: "+rs.getInt(1));
			
		}


	
		catch (SQLException e) {

		}
}

	public List<Customer> display() {
		List<Customer>list=new ArrayList<Customer>();
		try 
		{
			String m="SELECT Customer_ID,customer_Name,Password,City,State,ZIP,Country FROM CUSTOMER";
			PreparedStatement preparedStatement11=DatabaseConnectionDAO.geConnection().prepareStatement(m);
			ResultSet rs=preparedStatement11.executeQuery();
			while(rs.next())
			{
				Customer customer=new Customer();
				customer.setCustomerId(rs.getInt("Customer_ID"));
				customer.setCustomerName(rs.getString("customer_Name"));
				customer.setPassword(rs.getString("Password"));
				customer.setCity(rs.getString("City"));
				customer.setState(rs.getString("State"));
				customer.setZip(rs.getInt("ZIP"));
				customer.setCountry(rs.getString("Country"));
				list.add(customer);
			}
		}
		catch (Exception e) 
		{
		}
		return list;
	}

	public void delete(int customerId) {
		
		try 
		{
			String m="Delete from Customer where customer_Id=?";
			PreparedStatement preparedStatement=DatabaseConnectionDAO.geConnection().prepareStatement(m);
			preparedStatement.setInt(1, customerId);
			int n=preparedStatement.executeUpdate();
			if(n>0)
			{
				System.out.println("deleted");
			}
			else {
				System.out.println("enter valid fields");
			}
		}
		catch (Exception e) 
		{
			System.out.println("cant delete due to data constraints");
		}
	}

	public boolean search(String customerName) {
		boolean b=false;
	String searchQuery="SELECT CUSTOMER_ID,CUSTOMER_NAME,STATE,CITY,ZIP,COUNTRY FROM CUSTOMER WHERE CUSTOMER_NAME=?";
	try {
		PreparedStatement preparedStatement=DatabaseConnectionDAO.geConnection().prepareStatement(searchQuery);
		preparedStatement.setString(1, customerName);
		
		ResultSet rs=preparedStatement.executeQuery();
		if(rs.next())
		{
			b=true;
			System.out.println("Found customer with following details");
			System.out.println("Customer_ID:"+rs.getInt("Customer_ID")+" Customer_Name:"+rs.getString("Customer_Name")+" State:"+rs.getString("State")+" ZIP:"+rs.getString("ZIP")+" CITY:"+rs.getString("City")+" Country:"+rs.getString("Country"));
		}
		else 
		{
			System.out.println("No Customer Present");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return b;
	}

	public boolean search(int customerId) {
		boolean b=false;
		String searchQuery="SELECT CUSTOMER_ID,CUSTOMER_NAME,STATE,CITY,ZIP,COUNTRY FROM CUSTOMER WHERE CUSTOMER_ID=?";
		try {
			PreparedStatement preparedStatement=DatabaseConnectionDAO.geConnection().prepareStatement(searchQuery);
			preparedStatement.setInt(1, customerId);
			
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next())
			{
				b=true;
				System.out.println("Found customer with following details");
				System.out.println("Customer_ID:"+rs.getInt("Customer_ID")+" Customer_Name:"+rs.getString("Customer_Name")+" State:"+rs.getString("State")+" ZIP:"+rs.getString("ZIP")+" CITY:"+rs.getString("City")+" Country:"+rs.getString("Country"));
			}
			else 
			{
				System.out.println("No Customer Present");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
		
	}

	@Override
	public boolean update(int customerId,String c) {
		// TODO Auto-generated method stub
		String query="UPDATE Customer SET  city=? where Customer_ID=?";
		try {
			PreparedStatement preparedStatement=DatabaseConnectionDAO.geConnection().prepareStatement(query);
			preparedStatement.setInt(1, customerId);
			preparedStatement.setString(2, c);
			int n=preparedStatement.executeUpdate();
			if(n>0)
			{
				System.out.println("updated");
			}
			else
			{
				System.out.println("enter valid data");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean login(int id, String p) {
		// TODO Auto-generated method stub
		boolean b=false;
		String searchQuery="SELECT CUSTOMER_ID FROM CUSTOMER WHERE CUSTOMER_ID=? and password=?";
		try {
			PreparedStatement preparedStatement=DatabaseConnectionDAO.geConnection().prepareStatement(searchQuery);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2,p);
			
			
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next())
			{
				b=true;
			}
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return b;
	}
	
}