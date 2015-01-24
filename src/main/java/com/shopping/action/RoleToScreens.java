package com.shopping.action;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.to.RoleToScreenTo;

@Path("/roletoScreens")
public class RoleToScreens {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insert")
	public Response insertToScreens(RoleToScreenTo roleToScreenTo,
			@Context HttpServletRequest request) {
		
		roleToScreenTo= ShoppingCartFactory.getRoleToScreenDao().insertRolesToScreen(roleToScreenTo);
		
		return Response.status(201).entity(roleToScreenTo).build();
		
	}
}
