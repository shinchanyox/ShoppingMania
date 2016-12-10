package com.psl.client;

import java.util.List;
import java.util.Scanner;

import com.psl.bean.Employee;
import com.psl.bean.LeaveBalance;
import com.psl.bean.LeaveDetails;
import com.psl.util.Utility;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Utility u = new Utility() ;
		List<Employee> list = u.readEmployeeInformation() ;
		for(Employee e : list)
			System.out.println(e);
		System.out.println();
		List<LeaveBalance> listlb = u.readLeaveBalance() ;
		for(LeaveBalance lb : listlb)
			System.out.println(lb);
		
		System.out.println();
		List<LeaveDetails> listld = u.readLeaveDetails() ;
		for(LeaveDetails ld : listld)
			System.out.println(ld);
		
		Scanner s = new Scanner(System.in) ;
		System.out.println("please login :");
		System.out.println("enter employee id :");
		int id = s.nextInt() ;
		System.out.println("enter password :");
		String pass = s.next() ;
		
		
		boolean flag = u.login(list,id,pass) ;
		if(flag==true)
		{
			System.out.println("login successfull");
			u.menu(list ,listlb, listld) ; 
		}
		else
			System.out.println("login unsuccessfull");
		
		try
		{
			u.createFiles();
		}
		catch(Exception e){System.out.println(e);}
		
		

	}

}
