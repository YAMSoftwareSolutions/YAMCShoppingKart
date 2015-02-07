package com.shopping.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.to.RoleTo;
import com.shopping.to.RoleToScreenTo;
import com.shopping.to.UsersTo;

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
	
	// ROLE SEARCH BY ID
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Response searchRoleToScreen(RoleToScreenTo roleToScreenTo,
			@Context HttpServletRequest request) {
		try {
			System.out.println("roleId::::");
			System.out.println(roleToScreenTo.getRoleId());
			roleToScreenTo = ShoppingCartFactory.getRoleToScreenDao().searchByid(
					roleToScreenTo.getRoleId());
			return Response.status(201).entity(roleToScreenTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Record";
			return Response.status(403).entity(error).build();
		}
	}
	
	// USER Roles GET ALL
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAll(@Context HttpServletRequest request) {
		try {
			Collection<RoleToScreenTo> roleToScreenTo = new ArrayList<RoleToScreenTo>();
			roleToScreenTo = ShoppingCartFactory.getRoleToScreenDao().getAll();
			return Response.status(201).entity(roleToScreenTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Records";
			return Response.status(403).entity(error).build();
		}
	}
	
}
