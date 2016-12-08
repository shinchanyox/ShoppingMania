package com.client;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bean.Product;
import com.bean.Transaction;
import com.bean.User;
import com.exception.InvalidPasswordException;
import com.exception.InvalidUserException;

public class ClientProgram {

	/**
	 * @param args
	 */
	static List<Product> list  ;
	static long cardNo ;
	public static void main(String[] args) {
		
		ClientProgram cp = new ClientProgram() ;
		 list=cp.readProductsFromFile("Wonka_Products.txt") ;
		
		for(Product p : list)
		{
			//System.out.println("pikachu");
			System.out.println(p);
		}
		System.out.println();
		List<Transaction> lt = new ArrayList<Transaction>() ;
		cp.processOrder(lt);
		
		
		
	}
	public List<Product> getList()
	{
		return list ;
	}
	
	
	public List<Product> readProductsFromFile(String fullFilePath){
		List<Product> list = new ArrayList<Product>() ;
		
		Scanner s = null ;
		try
		{
			Class.forName("com.mysql.jdbc.Driver") ;
			Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/wonka", "root","root") ;
			PreparedStatement ps = c.prepareStatement("insert into product_tbl values(?,?,?,?)") ;
			s= new Scanner(new File(fullFilePath)) ;
			while(s.hasNext())
			{
				String[] t= s.nextLine().split("\t") ;
				int code = Integer.parseInt(t[0].trim()) ;
				String name = t[1].trim() ;
				float price = Float.parseFloat(t[2].trim()) ;
				int extra = Integer.parseInt(t[3].trim()) ;
				list.add(new Product(code,name,price,extra)) ;
				
				ps.setInt(1, code);
				ps.setString(2, name);
				ps.setFloat(3, price);
				ps.setInt(4, extra);
				ps.executeUpdate() ;
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		//for(Product)
		//TODO: Return valid list of products
		return list ;
	}
	
	public List<User> initUsers(){
		List<User> list = new ArrayList<User>() ;
		list.add(new User("Cadbury",1l,12345l,"andre")) ;
		list.add(new User("Linda",2l,67890l,"bista")) ;
		return list ;
		//TODO: Return valid list 
	}
	
	public boolean authenticate(User user, List<User> users) throws InvalidUserException, InvalidPasswordException{
		
		
		for(User u : users)
		{
			if(u.getCardNo()==user.getCardNo())
			{
				if(u.getPassword().equals(user.getPassword()))
				{
					return true ;
				}
				throw new InvalidPasswordException() ;
			}
		}
		throw new InvalidUserException() ;
	}
	
    public void processOrder(List<Transaction> transactions){
    	//TODO:Implement process order
    	ClientProgram cp = new ClientProgram() ;
    	List<Product> list =cp.getList() ;
    	List<User> listu =cp.initUsers() ;
    	Product pi =null ;
    	User ui =null ;
    	int quantity ;
    	
    	try
    	{

			Class.forName("com.mysql.jdbc.Driver") ;
			Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/wonka", "root","root") ;
			Statement s =c.createStatement() ;
			PreparedStatement ps =c.prepareStatement("insert into bill_tbl values(?,?,?,?)") ;
			
			ResultSet rs = s.executeQuery("select * from wonka.product_tbl") ;
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"	"+rs.getString(2)+"	"+rs.getFloat(3)+"	"+rs.getInt(4));
			}
			String ci ="" ;
			do
			{
				
				Scanner si = new Scanner(System.in) ;
				System.out.println("enter product id : ");
				int productNumber = si.nextInt() ;
				for(Product p : list)
				{
					if(p.getItemCode()==productNumber)
					{
						pi= p;
						break ;
					}
						
				}
				for(User u : listu)
				{
					if(u.getCardNo()==cardNo)
					{
						ui= u ;
						break ;
					}
				}
				
				
				System.out.println("enter the quantity : ");
				 quantity = si.nextInt() ;
				System.out.println("do you wish to continue (yes/no)");
				ci = si.next();
				transactions.add(new Transaction(pi,ui,quantity,0.0f)) ;
				ps.setInt(1, (int)cardNo);
				ps.setInt(2, productNumber);
				ps.setInt(3,quantity) ;
				ps.setInt(4,0) ;
				ps.executeQuery() ;
			}while(!(ci.equals("no"))) ;
			
			
    		
    	}
    	catch(Exception e){}
    	
    	
    }
    
    public List<Transaction> getPurchaseTransactionsFromDb(){
    	List<Transaction> list = new ArrayList<Transaction>() ;
    	ClientProgram cp = new ClientProgram() ;
    	List<Product> listp =cp.getList() ;
    	List<User> listu = cp.initUsers() ;
    	User ui = null ;
    	Product pi = null ;
    	double total  ;
    	
    	try
    	{
    		Class.forName("com.mysql.jdbc.Driver") ;
    		Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/wonka", "root","root") ;
    		Statement s = c.createStatement() ;
    		ResultSet rs  = s.executeQuery("select * from bill_tbl") ;
    		while(rs.next())
    		{
    			int userId = rs.getInt(1) ;
    			for(User u : listu)
    			{
    				if(u.getCardNo()==userId)
    				{
    					ui=u ;
    					break ;
    				}
    					
    			}
    			int itemCode = rs.getInt(2) ;
    			for(Product p : listp)
    			{
    				if(p.getItemCode()==itemCode)
    				{
    					pi = p ;
    					
    					break ;
    				}
    			}
    			int quantity = rs.getInt(3) ;
    			
    			total = pi.getPrice()*quantity  ;
    			list.add(new Transaction(pi,ui,quantity,total)) ;
    		}
    		
    	}
    	catch(Exception e){}
		
    	return list  ;
    	//TODO:Implement and return valid list
    }
    
    public double calculateFinalBillAmount(List<Transaction> purchaseList){
    	double bill =0.0 ;
    	for(Transaction t : purchaseList)
    	{
    		bill = bill + t.getTotal() ;
    		
    	}
    	return (bill+ bill*0.1) ;
    	//TODO:Implement and return a valid amount
    }
}