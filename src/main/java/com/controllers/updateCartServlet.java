package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Cart_Items;
import com.entities.User;
import com.helper.FactoryProvider;

public class updateCartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		User user =(User) req.getSession().getAttribute("user_details");
		int cartId = user.getCart().getCartId();
		int productId = Integer.parseInt(req.getParameter("product"));
		
		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		Cart_Items result = s.createQuery(
		        "FROM Cart_Items c WHERE c.cart.cartId = :cartId AND c.product.productId = :productId",
		        Cart_Items.class
		    )
		    .setParameter("cartId", cartId)
		    .setParameter("productId", productId)
		    .uniqueResult();
		
		int prevCount = result.getCount();
		if(action.equals("decrease")) {
			if(prevCount == 1) {
				//remove
				s.remove(result);
				
			}
			else if(prevCount > 1) {
				//decrement 
				result.setCount(prevCount-1);
			}
		
		}
		if(action.equals("increase")) {
			
			

			
			
			result.setCount(prevCount+1);
			

			
			
		}
		tx.commit();
		s.close();
		
		// iam showing the cart again :
		RequestDispatcher rd = req.getRequestDispatcher("showcart");
		rd.forward(req, resp);
		
	}
}
