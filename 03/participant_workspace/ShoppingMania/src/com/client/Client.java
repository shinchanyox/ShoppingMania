package com.client;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.bean.Category;
import com.bean.Product;
import com.bean.ShoppingCart;
import com.exception.ShoppingCartNotFoundException;
import com.util.DatabaseConnectionManager;

public class Client {

	//Use conn object for creating db connection
	static Connection conn;
	
	public static void main(String[] args) {
		// TODO: call methods you have implemented to present proper flow of menus with error handling etc
		Client c = new Client() ;
		List<Category> list = c.readAllCategoriesFromDb() ;
		for(Category ci : list)
			System.out.println(ci);
		
		c.populateCategoryProducts(list); 
		System.out.println();
		for(Category ci : list)
			System.out.println(ci);
		
		String username="" ;
		List<String> listp=new ArrayList<String>() ;
		username= c.createMenu(listp) ;
		
		ShoppingCart sc = c.createShoppingCart(username, listp, list) ;
		System.out.println(sc);
		
		c.storeShoppingCartIntoDB(sc);
		username= c.createMenu(listp) ;
		
		System.out.println("\n\n\n\n");
		try
		{
			List<Product> listpp =c.sortShoppingCart(username) ;
			for(Product  p : listpp)
				System.out.println(p);
		}
		catch(Exception e){}
		
		
	}
	

	public String createMenu(List<String> list)
	{
		Scanner s = new Scanner(System.in) ;
		System.out.println("Welcome to Shopping Mania!");
		int option ;
		String username ="";
		
		String productName ="" ;
		
		char c ;
			System.out.println("1. Create a Shopping Cart");
			System.out.println("2. Display a Shopping Cart");
			System.out.println("3. Exit");
			System.out.println("select an option");
			option = s.nextInt();
			switch(option)
			{
			case 1:
				System.out.println("enter username for shopping cart :");
				username = s.next() ;
				
				do
				{
					System.out.println("enter product name");
					productName = s.next();
					list.add(productName) ;
					System.out.println("add more products to shopping cart ?(y/n)");
					c = s.next().charAt(0) ;
				}while(c=='y') ;
				
				break ;
			case 2 :
				System.out.println("enter the user to load the cart :");
				username =s.next() ;
				
				
				
			}
			return username ;
			
			
		
	}
	public List<Category> readAllCategoriesFromDb(){
		// TODO: read product category details from db and return a valid list
		DatabaseConnectionManager dcm = new DatabaseConnectionManager() ;
		 List<Category> list = new  ArrayList<Category>() ;
		 try
		 {
			 conn = dcm.getConnection() ;
			 Statement s = conn.createStatement() ;
			 ResultSet rs = s.executeQuery("select * from category_tbl") ;
			 while(rs.next())
			 {
				 String filename = rs.getString(2) ;
				
				 String categoryName = rs.getString(3) ;
				 list.add(new Category(filename,categoryName,new ArrayList<Product>())) ;
			 }
			 
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
		 finally
		 {
			 try{
			 dcm.closeConnection();}catch(Exception e){}
		 }
		 return list ;
	}
	
	public void populateCategoryProducts(List<Category> categoryList){	
		
		// TODO: read product details for each category from its file and set the products for each category in the list passed.
		
		for(Category c : categoryList)
		{
			
			Scanner s = null ;
			try
			{
				s= new Scanner(new File("Categories\\"+c.getFileName())) ;
				s.nextLine() ;
				while(s.hasNext())
				{
					String[] t = s.nextLine().split(",");
					String title = t[0].trim();
					String[] b =t[1].trim().split(":");
					List<String> brand = new ArrayList<String>() ;
					for(String x : b)
						brand.add(x) ;
					Product p= new Product(title,brand) ;
					c.getProducts().add(p) ;
					
				}
				
			}
			catch(Exception e){System.out.println(e);}
		}

	}
	
	public ShoppingCart createShoppingCart(String userName, List<String> userInputProductNames,List<Category> categories){
		
		// TODO: create Shopping Cart in this method, apply validations to ignore the product names which are not existing in the categories Productlist.
		
		ShoppingCart sc = new ShoppingCart(userName,new ArrayList<Product>()) ;
		
		for(String s :userInputProductNames)
		{
			for(Category c :  categories)
			{
				for(Product p : c.getProducts())
				{
					if(s.equals(p.getTitle()))
						sc.getProducts().add(p) ;
				}
			}
		}
		return sc ;
	}
	
	public void storeShoppingCartIntoDB(ShoppingCart cartObj ){
		
		//TODO: Save the shopping cart into shoppingCarts_tbl 	
		DatabaseConnectionManager dcm = new DatabaseConnectionManager() ;
		try
		{
			conn = dcm.getConnection() ;
			PreparedStatement ps = conn.prepareStatement("insert into shoppingcart_tbl values(?,?)") ;
			List<Product> list = cartObj.getProducts() ;
			for(int i=0;i<list.size();i++)
			{
				
				ps.setString(1, cartObj.getName()); 
				ps.setString(2, cartObj.getProducts().get(i).getTitle());
				ps.executeUpdate() ;
				
				
			}
			
		}
		catch(Exception e){System.out.println(e);}
		finally
		{try{
			dcm.closeConnection();}catch(Exception e){System.out.println(e);}
		}
		

	}
	
	public List<Product> sortShoppingCart(String userName) throws  ShoppingCartNotFoundException{
	
		//TODO: 
		//1. Get the Shopping Cart of the username from db
		//2. create a list of products sorted in descending order of product name		 
		//3. return the sorted list 	
		//4. In case the username is not found in database then throw ShoppingCartNotFoundException
		//Sorting is expected to be implemented in this method and not in db.
		DatabaseConnectionManager dcm = new DatabaseConnectionManager() ;
		List<Product> list = new ArrayList<Product>() ;
		try
		{
			conn = dcm.getConnection() ;
			Statement s = conn.createStatement() ;
			ResultSet rs = s.executeQuery("select * from shoppingcart_tbl where  user_name='"+userName+"'") ;
			if(rs.next()==false)
			{
				throw new ShoppingCartNotFoundException("invalid user") ;
			}
			else
			{
				System.out.println("The items in the cart are as under :");
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"  "+rs.getString(2));
					list.add(new Product(rs.getString(2))) ;
				}
			}
				
		}
		catch(Exception e){System.out.println(e);}
		finally
		{
			try{dcm.closeConnection();}catch(Exception e){}
		}
		Collections.sort(list,new Comparator<Product>()
				{
					public int compare(Product p1,Product p2)
					{
						return p2.getTitle().compareTo(p1.getTitle()) ;
					}
				}) ;
		
		return list ;
		

	
	}
}	