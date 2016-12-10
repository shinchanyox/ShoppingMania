package com.psl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.psl.bean.Employee;
import com.psl.bean.LeaveBalance;
import com.psl.bean.LeaveDetails;

public class Utility {
	
	static int employeeID ;
	
	public boolean checkDuplicacy(List<LeaveDetails> listld,String type,Date start,Date end,int number,String getLeaveType)
	{
		boolean duplicate =false ;
		for(LeaveDetails ld : listld)
		{
			if(ld.getEmployeeID()==employeeID)
			{
				if(ld.getLeaveType().equals(type) && ld.getStartDate().compareTo(start)==0 && ld.getEndDate().compareTo(end)==0 && ld.getNumberOfDays()==number)
				{
					getLeaveType =ld.getLeaveType() ;
					duplicate = true ;
				}
			}
			
		}
		return duplicate ;
	}
	public void createFiles() throws Exception
	{
		FileInputStream fis = new FileInputStream("Leavedetails.csv") ;
		FileOutputStream fos = new FileOutputStream("Leavedetailsout.csv") ;
		int i=0 ;
		while((i=fis.read())!=-1)
			fos.write(i) ;
	}
	public void leaveTransactions(List<LeaveDetails> listld)
	{
		for(LeaveDetails ld : listld)
		{
			if(ld.getEmployeeID()==employeeID)
				System.out.println(ld);
		}
	}
	public void leaveBalance(List<LeaveBalance> listlb)
	{
		for(LeaveBalance lb : listlb)
		{
			if(lb.getEmployeeID()==employeeID)
				System.out.println(lb);
		}
	}
	
	public void applyLeave(List<LeaveDetails> listld,List<LeaveBalance> listlb,String type,Date start,Date end,int number)
	{
		boolean leave = true ;
		String getLeaveType="" ;
		for(LeaveBalance lb : listlb)
		{
			if(lb.getEmployeeID()==employeeID)
			{
				System.out.println(lb);
				if(checkDuplicacy(listld,type,start,end,number,getLeaveType)==true)
				{
					leave = false ;
					System.out.println("duplicate leaves not allowed");
					break ;
				}
				if(type.equals("OL"))
				{
					int getLeftLeaves = lb.getOl() ;
					if(getLeftLeaves < number)
					{
						leave = false ;
						System.out.println("low leave balance");
						break ;
					}
				}
				if(type.equals("PL"))
				{
					int getLeftLeaves = lb.getPl() ;
					if(getLeftLeaves < number)
					{
						leave = false ;
						System.out.println("low leave balance");
						break ;
					}
				}
				if(type.equals("LWP"))
				{
					int getLeftLeaves = lb.getLwp() ;
					if(getLeftLeaves < number)
					{
						leave = false ;
						System.out.println("low leave balance");
						break ;
					}
				}
				
				
			}
		}
		if(leave ==true)
		{
			updateTransactionFile("Leavedetailsout.csv",employeeID,start,end,number,type) ;
			System.out.println("yipeee...your leave has been approved");
		}
	}
	
	public void updateTransactionFile(String file,int id ,Date start,Date end,int number,String type)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy") ;
		FileOutputStream fos =null ;
		try
		{
			fos= new FileOutputStream(new File(file),true) ;
			String s = String.valueOf(employeeID)+","+sdf.format(start)+","+sdf.format(end)+","+type+","+String.valueOf(number) ;
			System.out.println(s);
			byte[] b = s.getBytes() ;
			fos.write(b);
			fos.flush() ;
			fos.close();
			
			
		
		}
		catch(Exception e){System.out.println(e);}
		
	}
	public void menu(List<Employee> list ,List<LeaveBalance> listlb, List<LeaveDetails> listld)
	{
		Scanner s = new Scanner(System.in) ;
		Date start =null ;
		Date end =null ;
		int number =0 ;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy") ;
		do
		{
			System.out.println("1.show leave balance");
			System.out.println("2.show leave transactions");
			System.out.println("3.apply for leave");
			System.out.println("4.logout");
			System.out.println("enter option :");
			int choice = s.nextInt() ;
			switch(choice)
			{
			case 1:
				leaveBalance(listlb) ;
				break ;
				
			case 2 :
				leaveTransactions(listld) ;
				break ;
			case 3:
				
				System.out.println("enter leave type :");
				String type = s.next() ;
				System.out.println("Enter start date (MM/dd/yyyy):");
				try
				{
					start = sdf.parse(s.next()) ;
					System.out.println("enter end date(MM/dd/yyyy) :");
					 end = sdf.parse(s.next()) ;
					 System.out.println("enter number of days :");
					 number = s.nextInt() ;
					 
				}
				catch(Exception e){System.out.println(e);}
				applyLeave(listld,listlb,type,start,end,number);
				
				break ;
				
			case 4 :
				employeeID= 0;
				
			
			}
			if(employeeID==0)
				break ;
		}while(true) ;
		
		
	}
	public boolean login(List<Employee> list ,int id ,String pass)
	{
		boolean flag = false ;
		for(Employee e : list)
		{
			if(e.getEmpID()==id && e.getPassword().equals(pass))
			{
				flag = true ;
				employeeID = id ;
			}
		}
		return true ;
	}
	public List<Employee> readEmployeeInformation()
	{
		List<Employee> list = new ArrayList<Employee>() ;
		Scanner s =null ;
		
		try
		{
			s= new Scanner(new File("EmployeeDetails.xml")) ;
			int id=0 ;
			String name="" ;
			String desig="" ;
			String pass="" ;
			
			s.nextLine();
			int count =0 ;
			while(s.hasNext())
			{
				count ++ ;
				String t = s.nextLine().trim();
				if(t.contains("<empid>"))
				{
					 id = Integer.parseInt(t.substring(7, 10)) ;
					 
					
				}
				if(t.contains("<name>"))
				{
					String temp =t.substring(6);
					int index = temp.indexOf('<') ;
					name=temp.substring(0, index);
				
					
				}
				if(t.contains("<desg>"))
				{
					String temp = t.substring(6);
					int index = temp.indexOf('<') ;
					desig=temp.substring(0, index);
				
					
				}
				if(t.contains("<password>"))
				{
					pass = t.substring(10, 15) ;
					
					
				}
				if(count==6)
				{
					list.add(new Employee(id,name,desig,pass)) ;
					count =0 ;
				}
				
			}
		}
		catch(Exception e){System.out.println(e);}
		return list ;
	}
	
	public List<LeaveBalance> readLeaveBalance()
	{
		List<LeaveBalance> list = new ArrayList<LeaveBalance>() ;
		Scanner s =null ;
		try
		{
			s= new Scanner(new File("LeaveBalance.csv")) ;
			s.nextLine();
			while(s.hasNext())
			{
				String[] t = s.nextLine().split(",") ;
				int id =Integer.parseInt(t[0].trim()) ;
				int ol =Integer.parseInt(t[1].trim()) ;
				int pl =Integer.parseInt(t[2].trim()) ;
				int lwp =Integer.parseInt(t[3].trim()) ;
				list.add(new LeaveBalance(id,ol,pl,lwp)) ;
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list ;
	}
	public List<LeaveDetails> readLeaveDetails()
	{
		List<LeaveDetails> list = new ArrayList<LeaveDetails>() ;
		Scanner s =null ;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy") ;
		try
		{
			s= new Scanner(new File("Leavedetails.csv")) ;
			s.nextLine();
			
			while(s.hasNext())
			{
				String[] t = s.nextLine().split(",") ;
				int id =Integer.parseInt(t[0].trim()) ;
				Date startDate = sdf.parse(t[1].trim()) ;
				Date endDate = sdf.parse(t[2].trim()) ;
				String leaveType = t[3].trim();
				int numberOfDays = Integer.parseInt(t[4].trim()) ;
				list.add(new LeaveDetails(id,startDate,endDate,leaveType,numberOfDays) ) ;
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list ;
	
	}
	

}
