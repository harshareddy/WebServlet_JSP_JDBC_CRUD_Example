package com.harshareddy.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harshareddy.dao.CustomerDAO;
import com.harshareddy.model.Customer;

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;

	public CustomerServlet() {
		super();
		customerDAO = new CustomerDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println("doGet CustomerServlet action " + action);

		switch (action) {
		case "customerform":
			customerForm(request, response);
			break;
		case "createcustomer":
			
			try {
				addCustomer(request, response);
			} catch (SQLException  e1) {
				
				e1.printStackTrace();
			}
			
			break;
		case "editcustomerform":
			try {
				editCustomerForm(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "updatecustomer":			
			try {
				updatecustomer(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case "deletecustomer":
			try {
				deleteCustomer(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "listcustomer":
			customerList(request, response);
			break;
		default:
			System.out.println("case default:" + action);
			customerList(request, response);
			break;
		}
	}
	
	
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException  {

		String custFirstName = request.getParameter("cust_first_name");
		String custLastName = request.getParameter("cust_last_name");
		String custEmail = request.getParameter("cust_email");
		String custCity = request.getParameter("cust_city");
		String custCountry = request.getParameter("cust_country");
		
		Customer customer = new Customer(custFirstName, custLastName, custEmail, custCity, custCountry);
		
		customerDAO.insertCustomer(customer);
		response.sendRedirect("CustomerServlet?action=listcustomer");
		//RequestDispatcher rd =request.getRequestDispatcher("/CustomerServlet?action=listcustomer");
	    //rd.forward(request, response);
		

	}

	private void updatecustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int custId = Integer.parseInt(request.getParameter("cust_id")); 
		String custFirstName = request.getParameter("cust_first_name");
		String custLastName = request.getParameter("cust_last_name");
		String custEmail = request.getParameter("cust_email");
		String custCity = request.getParameter("cust_city");
		String custCountry = request.getParameter("cust_country");
		
		Customer existingCust = new Customer(custId, custFirstName, custLastName, custEmail, custCity, custCountry);
		  boolean rowupdated =customerDAO.updateCustomer(existingCust);
		
		if (rowupdated) {
		  response.sendRedirect("CustomerServlet?action=listcustomer"); 
		}
		else
		{
			System.out.println("Something else went wrong");
		}
	}
	private void editCustomerForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        int cust_id = Integer.parseInt(request.getParameter("cust_id"));
        Customer customer = customerDAO.selectCustomer(cust_id);
        request.setAttribute("customer", customer);
        
        RequestDispatcher rd = request.getRequestDispatcher("customer-form.jsp");
        rd.forward(request, response);  
		
	}

	

	private void customerForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("customer-form.jsp");
		rd.forward(request, response);

	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int cust_id = Integer.parseInt(request.getParameter("cust_id"));
		
		boolean rowdeleted = customerDAO.deleteCustomer(cust_id);
		
		if(rowdeleted) {
			
			response.sendRedirect("CustomerServlet?action=listcustomer");
		}
		else {
			System.out.println("Could not delete, Please check logs");
		}
			
		
		 
	}

	

	private void customerList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Customer> customerList = null;
		try {
			customerList = customerDAO.selectAllCustomer();
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		request.setAttribute("customerList", customerList);
		request.getRequestDispatcher("customer-list.jsp").forward(request, response);

	}

}
