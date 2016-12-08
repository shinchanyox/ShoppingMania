package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager implements DBConnectionUtil {	
	
	Connection c =null ;
	public DatabaseConnectionManager() { }
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		c= DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingdb", "root","root") ;
		return c ;
		
	}
	public void closeConnection() throws SQLException
	{
		c.close() ;
	}
	
	
}
