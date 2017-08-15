package com.demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bo.UserDetailsBO;
import com.demo.to.UserDetails;

@WebServlet(urlPatterns = "/register")
public class RegistrationController extends HttpServlet {

	private String name;
	private String emailId;
	private String password;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		name = req.getParameter("name");
		emailId = req.getParameter("emailId");
		password = req.getParameter("password");

		UserDetails userDetails = new UserDetails();

		userDetails.setName(name);
		userDetails.setEmailId(emailId);
		userDetails.setPassword(password);

		UserDetailsBO bo = new UserDetailsBO();

		if (bo.addUser(userDetails)) {

			RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");

			dispatcher.forward(req, resp);

		} else {

			RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");

			dispatcher.forward(req, resp);
		}

	}

}
