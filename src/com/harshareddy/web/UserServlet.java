package com.harshareddy.web;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.harshareddy.dao.UserDAO;
import com.harshareddy.model.User;

//@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDAO;

	public UserServlet() {
		super();
		userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		//System.out.println("Action=" + action);
        
		
			try {

				switch (action) {
				case "newuser":
					userAdd(request, response);
					break;
				case "userform":
					userform(request, response);
					break;
				case "deleteuser":
					deleteUser(request, response);
					break;
				case "edituser":
					editform(request, response);
					break;
				case "updateuser":
					updateuser(request, response);
					break;

				case "listuser":
					userList(request, response);
					break;				
				default:
					userList(request, response);
					break;
				}

			} catch (Exception e) {
				System.out.println("Exception Caught:");
				System.out.println(e.getMessage());
			}
			
	}
        
		
	



	private void userAdd(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		User newuser = new User(name, email, country);
		userDAO.insertUser(newuser);
		response.sendRedirect("UserServlet?action=listuser");
	}

	private void updateuser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User modifiedUser = new User(id, name, email, country);

		boolean rowupdated = userDAO.updateUser(modifiedUser);

		if (rowupdated) {
			response.sendRedirect("UserServlet?action=listuser");
		} else {

			System.out.println("Could not update something has gone wrong");

		}

	}

	private void editform(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existinguser = userDAO.selectUser(id);
		request.setAttribute("user", existinguser);
		RequestDispatcher rd = request.getRequestDispatcher("user-form2.jsp");
		rd.forward(request, response);

	}

	private void userform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("user-form2.jsp");
		rd.forward(request, response);

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		if (userDAO.deleteUser(id)) {
			response.sendRedirect("UserServlet?action=listuser");
		} else {
			System.out.println("Error in deleting user");
		}
		;

	}

	private void userList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> userList = null;

		try {
			userList = userDAO.selectAllUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listUser", userList);
		RequestDispatcher rd = request.getRequestDispatcher("user-list.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
