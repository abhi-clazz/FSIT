package com.babytoy.DAO.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.babytoy.DAO.CustomerDAO;
import com.babytoy.exception.InvalidNameException;
import com.babytoy.model.Customer;
import com.babytoy.util.DatabaseConnection;

public class CustomerDAOImpl implements CustomerDAO 
{

	public void insert(Customer customer) throws InvalidNameException 
	{
		String insertQuery="INSERT INTO Customer(Customer_Id,Customer_Name,Password,State,City,ZIP,Country)VALUES(?,?,?,?,?,?,?)";
		try 
		{
			PreparedStatement preparedStatement1=DatabaseConnection.geConnection().prepareStatement("select customer_name from customer where customer_id=?");
			//code for primary key violation
			preparedStatement1.setInt(1, customer.getCustomerId());
			ResultSet resultSet=preparedStatement1.executeQuery();
			if(resultSet.next())
			{
				System.out.println("Customer with customerID  "+customer.getCustomerId()+ "is already registered.Register with another ID");
			}
			else
			{
				PreparedStatement preparedStatement=DatabaseConnection.geConnection().prepareStatement(insertQuery);
				preparedStatement.setInt(1, customer.getCustomerId());
				preparedStatement.setString(2, customer.getCustomerName());
				preparedStatement.setString(3, customer.getPassword());
				preparedStatement.setString(4, customer.getState());
				preparedStatement.setString(5, customer.getCity());
				preparedStatement.setInt(6, customer.getZip());
				preparedStatement.setString(7, customer.getCountry());
				int rowsAffected=preparedStatement.executeUpdate();
				System.out.println("Inserted "+rowsAffected+" Record to Customer Table");
			}
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

	public List<Customer> display() {
		List<Customer>list=new ArrayList<Customer>();
		try 
		{
			String m="SELECT Customer_ID,customer_Name,Password,City,State,ZIP,Country FROM CUSTOMER";
			PreparedStatement preparedStatement11=DatabaseConnection.geConnection().prepareStatement(m);
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
		e.printStackTrace();		
		}
		return list;
	}

	public void delete(int customerId) {
		
		try 
		{
			String m="Delete from Customer where customer_Id=?";
			PreparedStatement preparedStatement=DatabaseConnection.geConnection().prepareStatement(m);
			preparedStatement.setInt(1, customerId);
			preparedStatement.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void search(String customerName) {
	String searchQuery="SELECT CUSTOMER_ID,CUSTOMER_NAME,STATE,CITY,ZIP,COUNTRY FROM CUSTOMER WHERE CUSTOMER_NAME=?";
	try {
		PreparedStatement preparedStatement=DatabaseConnection.geConnection().prepareStatement(searchQuery);
		preparedStatement.setString(1, customerName);
		
		ResultSet rs=preparedStatement.executeQuery();
		if(rs.next())
		{
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
		
	}

	public void search(int customerId) {
		String searchQuery="SELECT CUSTOMER_ID,CUSTOMER_NAME,STATE,CITY,ZIP,COUNTRY FROM CUSTOMER WHERE CUSTOMER_ID=?";
		try {
			PreparedStatement preparedStatement=DatabaseConnection.geConnection().prepareStatement(searchQuery);
			preparedStatement.setInt(1, customerId);
			
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next())
			{
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
		
	}
}