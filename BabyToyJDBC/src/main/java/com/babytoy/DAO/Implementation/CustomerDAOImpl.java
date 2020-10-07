package com.babytoy.DAO.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import com.babytoy.DAO.CustomerDAO;
import com.babytoy.exception.InvalidNameException;
import com.babytoy.model.Customer;
import com.babytoy.util.DatabaseConnection;

public class CustomerDAOImpl implements CustomerDAO 
{
	static Connection connection=DatabaseConnection.geConnection();
	public void insert(Customer customer) throws InvalidNameException 
	{
		String insertQuery="INSERT INTO Customer(Customer_Id,Customer_Name,Password,State,City,ZIP,Country)VALUES(?,?,?,?,?,?,?)";
		try 
		{
			PreparedStatement preparedStatement1=connection.prepareStatement("select * from customer where customer_id=?");
			//code for primary key violation
			preparedStatement1.setInt(1, customer.getCustomerId());
			ResultSet resultSet=preparedStatement1.executeQuery();
			if(resultSet.next())
			{
				System.out.println("Customer with customerID  "+customer.getCustomerId()+ "is already registered.Register with Another ID");
			}
			else
			{
			PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
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
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
		
		
}
		
}