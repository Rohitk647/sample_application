package com.demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bo.UserDetailsBO;
import com.demo.to.UserDetails;

public class LoginController extends HttpServlet {

	private String userName;
	private String password;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		userName = req.getParameter("userName");
		password = req.getParameter("password");

		UserDetailsBO bo = new UserDetailsBO();

		UserDetails userDetails = bo.authenticate(userName, password);

		if (userDetails != null && userDetails.isValidUser()) {

			RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.jsp");

			dispatcher.forward(req, resp);
			
		} else {

			RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");

			dispatcher.forward(req, resp);
		}

	}

}
