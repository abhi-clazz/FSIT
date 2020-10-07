package com.babytoy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String databaseDriverClass="com.mysql.cj.jdbc.Driver";
	private static final String UserName="root";
	private static final String password="abhi";
	private static final String databaseURL ="jdbc:mysql://localhost:3306/abhiclazz";
	private static Connection connection=null;
	
	static
	{
		try 
		{
			//System.out.println("Loading Driver Class...");
			Class.forName(databaseDriverClass);
			//System.out.println("Establishing Database Connection");
			connection=DriverManager.getConnection(databaseURL,UserName,password);
			//System.out.println("Connected to  instance at "+databaseURL);
			
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static Connection geConnection()
	{
		return connection;
		
	}

}
