package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Order_Product;
import com.entities.User;
import com.helper.FactoryProvider;

public class CancelOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int productId = Integer.parseInt(req.getParameter("cartItemId")); 
        User user = (User) req.getSession().getAttribute("user_details"); 
        int userId = user.getId();
        int orderId = Integer.parseInt(req.getParameter("orderId"));

        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            //iam  Fetching the Order_Product row that belongs to this user and matches the product
            List<Order_Product> orderProducts = session.createQuery(
                    "select op from Order_Product op where op.order.userId.id = :userId and op.order.orderId = :orderId and op.product.productId = :productId",
                    Order_Product.class)
                .setParameter("userId", userId)
                .setParameter("orderId", orderId)
                .setParameter("productId", productId)
                .list();

            if (orderProducts != null && !orderProducts.isEmpty()) {
                for (Order_Product op : orderProducts) {
                    session.remove(op); // remove each product
                   
                }
            } else {
                System.out.println("No products found to remove");
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        resp.sendRedirect("myorders");
    }
}