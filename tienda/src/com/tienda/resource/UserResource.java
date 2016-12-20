package com.tienda.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tienda.bean.ExceptionMessage;
import com.tienda.bean.User;
import com.tienda.service.TiendaService;
import com.tienda.util.UserNotFoundException;


@Path("/users")
public class UserResource { // resource class
	
	@Context    // dependency injection 
	private ResourceContext  resourceContext ;
	//@Path("/my-method")
	@GET
	//@Produces(value="application/json") //MIME type/Media type
	@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	
	@Path("{uname}") // template parameter
	public User fetchUserDetails(@PathParam("uname")/*@QueryParam("uname")*/String username) throws UserNotFoundException // resource method(must be mapped to http GET)
	{
		User user  ;
		user = new TiendaService().getUserDetails(username) ;
		return user ;
	}
	
	@Path("/{username}/{sub-resource-name}")
	public Object getSubResource(@PathParam("sub-resource-name")String subResourceName) // sub-resource locator 
	{
		if("orders".equals(subResourceName))
		{
			return resourceContext.getResource(OrderResource.class) ;
		}
		else if("wishlist".equals(subResourceName))
		{
			//return resourceContext.getResource(WishlistResource.class) ;
		}
		
		
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST)
					.entity(new ExceptionMessage(
							"Resource "+subResourceName+" not found")
					).build()) ;
		
		
	}
	
	
	

}
