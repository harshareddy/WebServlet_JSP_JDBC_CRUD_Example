package com.harshareddy.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	public LoginFilter() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
	//	HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);
		String loginURI = req.getContextPath() + "/login.html";
		String loginServletURI = req.getContextPath() + "/LoginServlet";

		boolean loggedIn = session != null && session.getAttribute("username") != null;
		boolean loginRequest = req.getRequestURI().equals(loginURI);
		boolean loginRequestSev = req.getRequestURI().equals(loginServletURI);
//
		System.out.println("Session:" + session);
		System.out.println("userName:" + req.getSession().getAttribute("username"));
		System.out.println("loggedIn: " + loggedIn);
		System.out.println("loginURI: " + req.getRequestURI());
		

		if (loggedIn || loginRequest || loginRequestSev) {

			chain.doFilter(request, response);

		} else {
			req.getRequestDispatcher("login.html").forward(request, response);

			System.out.println("Redirect to login page");

		}

	}

}
