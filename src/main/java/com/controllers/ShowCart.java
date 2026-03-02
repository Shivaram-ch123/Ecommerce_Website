package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.entities.*;
import com.helper.FactoryProvider;

import Dao.CartDao;

public class ShowCart extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("hii welcome to the cart");
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user_details");
		int cartId = user.getCart().getCartId();
		
		List<Cart_Items> Cart_Items_List=CartDao.DisplayCartItemsint(user);
		
		
		// i want the control needs to =go to the jsp so that it will display the cart items 
		// need to calculate the total cost here 
		Session s = FactoryProvider.getFactory().openSession();

		
		List<Cart_Items> items = s.createQuery(
			    "from Cart_Items c where c.cart.cartId = :cartId order by c.product.productId",
			    Cart_Items.class)
			.setParameter("cartId", cartId)
			.list();
		
		int totalCost = 0;
		
		
		for(int i=0;i<items.size();i++) {
			int count = items.get(i).getCount();
			int cost =items.get(i).getProduct().getCost();
			totalCost+=(count*cost);
			
		}
		
		req.setAttribute("cart_list",items);
		req.setAttribute("totalCost",totalCost);

		
		RequestDispatcher rd = req.getRequestDispatcher("CartPage.jsp");
		rd.forward(req, resp);
	}
}
