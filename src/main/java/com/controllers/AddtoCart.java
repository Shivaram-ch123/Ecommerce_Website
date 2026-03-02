package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.User;

import Dao.CartDao;

public class AddtoCart extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//so here some one is calling me to add the product to the cart
		
		int productId = Integer.parseInt(req.getParameter("productId"));
		HttpSession session = req.getSession();
		if(session==null) {
			//send dispatcher to a new page where that page says that we cannot add to the cart : first login and then try again
		}
		else {
			User user = (User)session.getAttribute("user_details");
			int userId = user.getId();
			boolean addedToCart = CartDao.AddProducttoCart(userId,productId);
			if(addedToCart) {
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("Added Succesfully");
				out.println("<a href=\"HomePage.jsp\">Go Back</a>");
				out.println("</body>");
				out.println("</html>");
			}
			else {
				System.out.println("Cannot add , there is a problem in adding the product to the cart");
			}
		}
	}
}
