package com.myorg.tutorial.epmproducts;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
* Servlet implementation class HomeServlet
*/
@WebServlet("/*")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"Display"}))
public class Security extends HttpServlet {
	private static final long serialVersionUID = 5689120501367518278L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().println("Funcou!"); //request.getUserPrincipal()
		
		EPMSampleService c;
		try {
			c = new EPMSampleService();
			c.getSampleProducts();
		
		
		response.getWriter().println(c.getSampleProducts()); //request.getUserPrincipal()
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}