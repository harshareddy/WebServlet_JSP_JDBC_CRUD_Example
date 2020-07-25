package com.harshareddy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
        PrintWriter writer = response.getWriter();
		 if (session != null) {
			session.removeAttribute("username");
			rd.include(request, response);
			 writer.println("<br/><br/><h3>You have logged out successfully<h3>");
			
		}
		 else 
		 {
			writer.println("Session is not there ");
		 }
		 
		 
		
	}

}
