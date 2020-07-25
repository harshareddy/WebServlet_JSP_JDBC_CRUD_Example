package com.harshareddy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("uname");
		String password = request.getParameter("upass");
		
		//System.out.println("loggig from login servlet");

		if (userName.equals("admin") && password.equals("admin")) {

			// System.out.println("Login Successfull");

			HttpSession session = request.getSession(true);
			session.setAttribute("username", userName);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);

		} else {

			PrintWriter writer = response.getWriter();
			request.getRequestDispatcher("login.html").include(request, response);
			writer.println("<h3 style='color:red' >Invalid Login...<h3>");

		}
	}

}
