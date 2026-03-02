package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;


// getting the com.entities
import com.entities.*;

import Dao.*;

public class LoginPageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//when ever something comes i need to take the request from the jsp
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String phoneNumber = req.getParameter("phonenumber");
		Cart cart1 = new Cart();
		//List<Order> orderlist=new ArrayList<>();
		
		PrintWriter out = resp.getWriter();
		
		boolean returnAnswer =false;
		
		try {
			returnAnswer = UsersDao.InsertIntoDatabase(name, phoneNumber,cart1);
		}
		catch (Exception e) {
			out.println(e);
		}
		
		
		
		
		if(returnAnswer) {
			out.println("<h1> hello </h1>"+ name + "You have sucessfully Registered");
			out.println("Login here : <a href=\"SignInPage.jsp\">Login</a>");
			
		}else {
			out.println("<h1> hello </h1>"+ name + "Sorry try again...");
		}
		
		
		
		
	}
}
