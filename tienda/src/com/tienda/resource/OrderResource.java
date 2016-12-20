package com.tienda.resource;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tienda.bean.Order;
import com.tienda.service.TiendaService;
import com.tienda.util.OrderNotFoundException;

public class OrderResource {
	
	@GET
	@Path("{ord-number}")
	@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) 
	public Order fetchOrderDetailsForUser(@PathParam("username")String username,@PathParam("ord-number")String number) throws OrderNotFoundException
	{
		Order order  ;
		order = new TiendaService().getOrderDetailsForUser(username, number) ;
		return order ;
	}
	@GET
	@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Set<Order> fetchAllOrdersForUser(@PathParam("username")String username)
	{
		Set<Order> orders = new TiendaService().getAllOrdersForUser(username);
		return orders ;
	}
	@POST
	@Consumes(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void createOrder(Order order)
	{
		System.out.println(order.getOrderedBy().getUsername());
		
	}

}
