package com.shopping.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.daofactory.ShoppingCartFactory;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("username::::::::::::"+req.getParameter("username"));
		System.out.println("password::::::::::::"+req.getParameter("password"));
		int userId = ShoppingCartFactory.getUserDao().verifyLogin(req.getParameter("username"), req.getParameter("password"));
		System.out.println("userId::::::::::::"+userId);
		if (userId != 0) {
			req.setAttribute("userId", userId);
			HttpSession httpsession = req.getSession(true);
			httpsession.setAttribute("ipaddress", req.getRemoteHost());
			httpsession.setAttribute("userId", userId);
			resp.sendRedirect("../admin");
		}else{
			resp.sendRedirect("../admin/login.html");
		}
	}
}
