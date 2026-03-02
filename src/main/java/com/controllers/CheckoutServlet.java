package com.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Random;

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

import Dao.CartDao;
import Dao.OrderDao;
import Dao.OrderProductDao;

public class CheckoutServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. i need to generate a orderid

		// so iam here adding manually to orders and order product table

		// so the req says that the user want to buy the list of products

		// create a row in the order table and orderproduct tabel

		HttpSession session = req.getSession(false);
		// here at this step i will get a existance session if exists

		if (session == null) {
			// ERROR PAGE HANDLE I NEED TO DO LATER
			System.out.println("1st error");
		} else {
			User user = (User) session.getAttribute("user_details");
			// add to the order table now
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			// here i need to create a order obj
			
			Order result = s.createQuery(
			        "select o from Order o where o.userId.id = :user",
			        Order.class)
			    .setParameter("user", user.getId())
			    .setMaxResults(1)
			    .uniqueResult();
			
			
			Order o = new Order(user);
				
			
			s.persist(o);
			tx.commit();
			s.close();
			
			
			
			String address = req.getParameter("Address");
			boolean answer = OrderProductDao.AddToOrderProductTable(user, o, address,s);
		     

			
			if (answer == true) {

				System.out.println("Congrats");

			}
			
			// secound work that i had is i need to do remov ethe elemnts from the cart 
			s = FactoryProvider.getFactory().openSession();
			try {
			    tx = s.beginTransaction();

			    int deletedCount = s.createMutationQuery(
			            "delete from Cart_Items o where o.cart.cartId = :cartId")
			        .setParameter("cartId", user.getCart().getCartId())
			        .executeUpdate();
			    
			   
			    tx.commit();

			    System.out.println("Rows deleted: " + deletedCount);
			} catch (Exception e) {
			    if (tx != null) tx.rollback();
			    System.out.println("Error here ");
			    e.printStackTrace();
			} finally {
			    s.close();
			}
			
			
			
			

			

		

			RequestDispatcher rd = req.getRequestDispatcher("FinalBuyPage.jsp");
			rd.forward(req, resp);

		}

	}

}
