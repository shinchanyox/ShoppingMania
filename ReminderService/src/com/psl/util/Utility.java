package com.psl.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.psl.bean.Employee;
import com.psl.bean.EventEnum;
import com.psl.exception.InvalidDayException;

public class Utility implements Reminder_Service_interface{

	@Override
	public List<Employee> fetchAllEmployeeDetails() {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<Employee>() ;
		Scanner s =null ;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd") ;
		try
		{
			s= new Scanner(new File("employeetxt.txt")) ;
			while(s.hasNext())
			{
				String[] t = s.nextLine().split("-") ;
				if(t.length==2)
				{
					int id = Integer.parseInt(t[0].trim()) ;
					String name = t[1].trim();
					list.add(new Employee(id,name,null,null)) ;
				}
				else
				{
					int id = Integer.parseInt(t[0].trim()) ;
					String name = t[1].trim();
					Date birth= sdf.parse(t[2].trim()) ;
					Date anni= sdf.parse(t[3].trim()) ;
					list.add(new Employee(id,name,birth,anni)) ;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list ;
	}

	@Override
	public StringBuffer fetchEventMessage(String fileName) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer() ;
		Scanner s =null ;
		try
		{
			s= new Scanner(new File(fileName)) ;
			while(s.hasNext())
			{
				sb.append(s.nextLine()).append("\n") ;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return sb ;
	}

	@Override
	public Map<EventEnum, Set<Employee>> fetchEventDetails(
			List<Employee> empList, Date date) throws InvalidDayException {
		// TODO Auto-generated method stub
		 Map<EventEnum, Set<Employee>> map = new HashMap<EventEnum, Set<Employee>>() ;
		 for(EventEnum e : EventEnum.values())
			 map.put(e, new HashSet<Employee>()) ;
		 Date birth =null ;
		 Date anni=null ;
		 for(Employee e : empList)
		 {
			 birth = e.getBirthDate() ;
			 if(birth!=null)
			 {
				 if(birth.compareTo(date)==0)
					 map.get(EventEnum.BIRTHDAY).add(e) ;
			 }
			 anni = e.getAnniversaryDate() ;
			 if(anni!=null)
			 {
				 if(anni.compareTo(date)==0)
					 map.get(EventEnum.ANNIVERSARY).add(e) ;
			 }
		 }
		 return map ; 
	}

	@Override
	public void sortEmployeesByName(Set<Employee> empSet) {
		// TODO Auto-generated method stub
		Set<Employee> set = new TreeSet<Employee>(new Comparator<Employee>()
				{
					public int compare(Employee e1,Employee e2)
					{
						return e1.getEmployeeName().compareTo(e2.getEmployeeName());
					}
			
					}) ;
		
		set.addAll(empSet) ;
		empSet.clear();
		empSet.addAll(set) ;
		
	}

	@Override
	public int calculateEventYears(Date eventDate, Date sysDate)
			throws Exception {
		// TODO Auto-generated method stub
		Calendar event = Calendar.getInstance() ;
		Calendar today = Calendar.getInstance() ;
		event.setTime(eventDate);
		today.setTime(sysDate);
		
		int year = today.get(Calendar.YEAR)-event.get(Calendar.YEAR) ;
		if(today.get(Calendar.MONTH) < event.get(Calendar.MONTH))
		{
			year-- ;
		}
		else if(today.get(Calendar.MONTH) == event.get(Calendar.MONTH))
		{
			if(today.get(Calendar.DAY_OF_MONTH) <event.get(Calendar.DAY_OF_MONTH))
					year-- ;
		}
		return year ;
	}

	@Override
	public Map<EventEnum, List<StringBuffer>> employeeWishContent(
			Map<EventEnum, Set<Employee>> empListMap, StringBuffer msg) {
		// TODO Auto-generated method stub
		Utility u = new Utility() ;
		Calendar c = Calendar.getInstance() ;
		int age =0 ;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy") ;
		 Map<EventEnum, List<StringBuffer>> map = new HashMap<EventEnum, List<StringBuffer>>() ;
		 for(EventEnum e : EventEnum.values())
			 map.put(e,new ArrayList<StringBuffer>()) ;
		 List<StringBuffer> birth = new ArrayList<StringBuffer>() ;
		 List<StringBuffer> anni = new ArrayList<StringBuffer>() ;
		 for(Map.Entry<EventEnum, Set<Employee>> entry : empListMap.entrySet())
		 {
			 for(Employee e : entry.getValue())
			 {
				 String a = msg.toString() ;
				 a=a.replace("<NAME>", e.getEmployeeName()) ;
				 a=a.replace("<EVENT>", entry.getKey().name()) ;
				 a=a.replace("<EVENTDATE>",entry.getKey()==EventEnum.ANNIVERSARY?sdf.format(e.getAnniversaryDate()):sdf.format(e.getBirthDate())) ;
				 try
				 {
					 if(entry.getKey()==EventEnum.ANNIVERSARY)
						 age = u.calculateEventYears(e.getAnniversaryDate(), c.getTime()) ;
					 else
						 age = u.calculateEventYears(e.getBirthDate(), c.getTime()) ;
				 }
				 catch(Exception e1){System.out.println(e1);}
				 a=a.replace("<AGE>",String.valueOf(age)) ;
				 
				 if(entry.getKey()==EventEnum.ANNIVERSARY)
					 anni.add(new StringBuffer(a)) ;
				 else
					 birth.add(new StringBuffer(a)) ;
					 
				 
			 }
		 }
		 for(Map.Entry<EventEnum, List<StringBuffer>> entry : map.entrySet())
		 {
			 if(entry.getKey()==EventEnum.ANNIVERSARY)
				 entry.getValue().addAll(anni) ;
			 else
				 entry.getValue().addAll(birth) ;
				 
		 }
		 return map ;
	}

}
