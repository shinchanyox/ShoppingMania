package com.psl.client;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.psl.bean.Employee;
import com.psl.bean.EventEnum;
import com.psl.util.Utility;

public class Client {

	public static void main(String [] s)
	{
	Utility u = new Utility() ;
	List<Employee> list = u.fetchAllEmployeeDetails() ;
	for(Employee e : list)
		System.out.println(e) ;
	System.out.println();
	StringBuffer sb = u.fetchEventMessage("eventmsg.txt") ;
	System.out.println(sb);
	System.out.println();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd") ;
	Map<EventEnum, Set<Employee>> map =null ;
	Date d=null ;
	try
	{
		d = sdf.parse("2007/09/04") ;
		d = sdf.parse("1985/08/25") ;
		 map = u.fetchEventDetails(list,d ) ;
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	for(Map.Entry<EventEnum, Set<Employee>> entry : map.entrySet())
	{
		System.out.print(entry.getKey());
		for(Employee e : entry.getValue())
			System.out.print(e+"  ");
		System.out.println("\n");
	}
	System.out.println();
	Set<Employee> set = new LinkedHashSet<Employee>() ;
	set.addAll(list) ;
	u.sortEmployeesByName(set);
	for(Employee e : set)
		System.out.println(e);
	
	System.out.println();
	Calendar c = Calendar.getInstance() ;
	int year =0 ;
	try
	{
		year = u.calculateEventYears(d, c.getTime()) ;
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	System.out.println(year);
	System.out.println();
	Map<EventEnum, List<StringBuffer>> mapi = u.employeeWishContent(map, sb) ;
	System.out.println();
	for(Map.Entry<EventEnum, List<StringBuffer>> entry : mapi.entrySet())
	{
		System.out.println(entry.getKey());
		for(StringBuffer sbi : entry.getValue())
			System.out.println(sbi);
		
		System.out.println("\n");
	}
	
}
}
