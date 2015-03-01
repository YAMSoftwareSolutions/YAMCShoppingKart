package com.shopping.action;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.shopping.daofactory.ShoppingCartFactory;
import com.shopping.to.AuthTo;

@Path("/accessService")
public class AuthService {
	@POST
	@Path("/login")
	public Response loginAuth(AuthTo authto,
			@Context HttpServletRequest request, @Context UriInfo uriInfo) {
		int userId;
		try {
			System.out.println("username::::::::::::"+authto.getUsername());
			System.out.println("password::::::::::::"+authto.getPassword());
			userId = ShoppingCartFactory.getUserDao().verifyLogin(authto.getUsername(), authto.getPassword());
			System.out.println("userId::::::::::::"+userId);
			if (userId != 0) {
				request.setAttribute("userId", userId);
				HttpSession httpsession = request.getSession(true);
				httpsession.setAttribute("ipaddress", request.getRemoteHost());
				httpsession.setAttribute("userId", userId);
				URI uri = uriInfo.getBaseUriBuilder().path("../admin").build();
				return Response.seeOther(uri).build();
			}else{
				URI uri = uriInfo.getBaseUriBuilder().path("../admin/login.html").build();
				return Response.seeOther(uri).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			String error = "ConstraintViolationException";
			return Response.status(403).entity(error).build();
		}
	}
	
	@POST
	@Path("/userLogin")
	public Response userLoginAuth(AuthTo authto,
			@Context HttpServletRequest request, @Context UriInfo uriInfo) {
		int userId;
		try {
			System.out.println("username::::::::::::"+authto.getUsername());
			System.out.println("password::::::::::::"+authto.getPassword());
			userId = ShoppingCartFactory.getUserDao().verifyLogin(authto.getUsername(), authto.getPassword());
			System.out.println("userId::::::::::::"+userId);
			if (userId != 0) {
				request.setAttribute("userId", userId);
				HttpSession httpsession = request.getSession(true);
				httpsession.setAttribute("ipaddress", request.getRemoteHost());
				httpsession.setAttribute("userId", userId);
				URI uri = uriInfo.getBaseUriBuilder().path("../app/#/orderconformation").build();
				return Response.seeOther(uri).build();
			}else{
				URI uri = uriInfo.getBaseUriBuilder().path("../app/#/login").build();
				return Response.seeOther(uri).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			String error = "ConstraintViolationException";
			return Response.status(403).entity(error).build();
		}
	}

	@POST
	@Path("/logout")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logoutAuth(@Context HttpServletRequest request) {
		// invalidate the session if exists
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return Response.status(201).entity("LOGOUT SUCESS").build();

	}
}
