package com.psl.client;

import java.io.File;
import java.util.Scanner;


public class Pikachu {
	
	int id ;
	String name ;
	float version ;
	
	
	public Pikachu(int id, String name, float version) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
	}
	public Pikachu(){}
	


	@Override
	public String toString() {
		return "Pikachu [id=" + id + ", name=" + name + ", version=" + version
				+ "]";
	}
	public static void main(String[] args) {
		Scanner s =null ;
		try
		{
			s= new Scanner(new File("well.txt")) ;
			while(s.hasNext())
			{
				int id=0 ;
				String name=null ;
				float version =0.0f;
				String abc = s.nextLine();
				if(abc.trim().length()==0)
					continue ;
				String[] t =abc.split(" +") ;
				
			
				if(t.length==3)
				{
					 id = Integer.parseInt(t[0].trim()) ;
					 name = t[1].trim() ;
					 version = Float.parseFloat(t[2].trim()) ;
				}
				else if(t.length==2)
				{
					 id = Integer.parseInt(t[0].trim()) ;
					 name = t[1].trim() ;
					 
					
				}
				else if(t.length==1)
				{
				
					 id = Integer.parseInt(t[0].trim()) ;
					 
				}
				
				System.out.println(new Pikachu(id,name,version));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
		
		
		
		
		
		
		
	

}
