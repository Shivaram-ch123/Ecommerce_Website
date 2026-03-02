package com.controllers;
import java.io.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.User;

public class UpdatePasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	System.out.println("yes");
        String username = request.getParameter("name");
        String newPassword = request.getParameter("password");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");


        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        
        HttpSession s = request.getSession();
        User user1 = (User)s.getAttribute("user_details");

        try {
            tx = session.beginTransaction();

            // Fetch user by name
            User user = session.createQuery("FROM User U WHERE U.id = :userId", User.class)
                    .setParameter("userId", user1.getId()) 
                    .uniqueResult();

            if (user != null) {
            	user.setName(username);
                user.setPhonenumber(newPassword);
                
                tx.commit();
                out.println("<h3>Details updated successfully!</h3>");
            } else {
                out.println("<h3>User not found!</h3>");
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            out.println("<h3>Error updating Your Details!</h3>");
        } finally {
            session.close();
            factory.close();
        }
        
        out.println("<a href=\"HomePage.jsp\">Go to Home Page</a>");
        
        
    }
}