package com.psl.util;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Util {
	
	public static void display(Map<String,Map<String,List<String>>> map)
	{
		for(Map.Entry<String,Map<String,List<String>>> entry : map.entrySet())
		{
			System.out.print(entry.getKey()+" ");
			for(Map.Entry<String,List<String>> e : entry.getValue().entrySet())
			{
				System.out.print(e.getKey()+" ");
				for(String a : e.getValue())
					System.out.print(a+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
	
		Map<String,Map<String,List<String>>> map = new LinkedHashMap<String,Map<String,List<String>>>() ;
		
		Scanner s =null ;
		try
		{
			s= new Scanner(new File("pikachu.txt")) ;
			while(s.hasNext())
			{
				Map<String,List<String>> state = new LinkedHashMap<String,List<String>>() ;
				List<String> list = new ArrayList<String>() ;
				String[] t1 = s.nextLine().split(":") ;
				String[] t2 = t1[1].split("-") ;
				String[] t3 = t2[1].substring(1, t2[1].length()-1).split(",") ;
				for(String city : t3)
					list.add(city) ;
				if(map.containsKey(t1[0]))
				{
					if(map.get(t1[0]).containsKey(t2[0]))
					{
						map.get(t1[0]).get(t2[0]).addAll(list) ;
					}
					else	
					map.get(t1[0]).put(t2[0],list) ;
				}
				else
				{
					
					state.put(t2[0], list) ;
					map.put(t1[0], state) ;
				}
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		display(map);

	}
	
}
