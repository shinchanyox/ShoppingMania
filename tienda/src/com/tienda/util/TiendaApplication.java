package com.tienda.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.tienda.resource.UserResource;

@ApplicationPath("/") //simple slash indicates app is bound with base uri 
public class TiendaApplication extends Application {
//this class tells the jersey runtime about the resource classes created 	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes ;
		classes = new HashSet<Class<?>>() ;
		
		classes.add(UserResource.class) ;
		return classes ;
	}
	
	

}
