package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.User;

import Dao.UsersDao;

public class SignInPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// here i am getting a req to sighn in (i need to check if th euser exist )
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		PrintWriter out=resp.getWriter();
		User resultUser = UsersDao.CheckExistance(name,phone);
		if(resultUser!=null) {
			// her ewe can say that the user exists
			HttpSession session = req.getSession();//it will get if there is a session already available or open a new session
			session.setAttribute("user_details", resultUser);
			resp.sendRedirect("HomePage.jsp");
		}
		else {
			out.println("Hello you are not registered");
		}
	}
}
