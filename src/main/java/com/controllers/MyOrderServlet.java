package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Cart_Items;
import com.entities.Order;
import com.entities.Order_Product;
import com.entities.User;
import com.helper.FactoryProvider;

public class MyOrderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user =(User)session.getAttribute("user_details");
		
		
		
		Session s = FactoryProvider.getFactory().openSession();
		// here i need to create a order obj
		
//		Order result = s.createQuery(
//		        "select o from Order o where o.userId.id = :user",
//		        Order.class)
//		    .setParameter("user", user.getId())
//		    .setMaxResults(1)
//		    .uniqueResult();
//		
//
//		if(result==null) {
//
//			
//			
//		}
//		else {
//			// i have to get the orderId
//			int orderId = result.getOrderId();
//			List<Order_Product> list = s.createQuery(
//			        "from Order_Product op where op.order.orderId = :orderId",
//			        Order_Product.class)
//			    .setParameter("orderId", orderId)
//			    .list();
//			
//			req.setAttribute("ordered_items", list);
//			RequestDispatcher rd = req.getRequestDispatcher("MyOrdersPage.jsp");
//			rd.forward(req, resp);
//			
//			
//			
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		// first i need to get all the order ids of a perticular user from the orders table
		
		List<Order> orders = s.createQuery(
		        "FROM Order o WHERE o.userId.id = :userId",  // HQL
		        Order.class
		    )
		    .setParameter("userId", user.getId())
		    .list();
		List<List<Order_Product>> list = new ArrayList<>();
		for(int i=0;i<orders.size();i++) {
			// this is one order id
			// i need to get all the products of this order id
			List<Order_Product> temp = s.createQuery(
			        "FROM Order_Product c WHERE c.order.orderId = :orderId",
			        Order_Product.class
			    )
			    .setParameter("orderId", orders.get(i).getOrderId())
			    .list();
			list.add(temp);
		}
		

		
		
		

		s.close();
		
		req.setAttribute("list", list);  // keep attribute name as 'list'
		RequestDispatcher rd = req.getRequestDispatcher("MyOrdersPage.jsp");
		rd.forward(req, resp);
		
		
		
	}
}
