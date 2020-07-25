package com.harshareddy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.harshareddy.model.Customer;

public class CustomerDAO {

	private static final String insertCustomerSQL = "INSERT INTO  Customers(cust_first_name, cust_last_name, cust_email, cust_city, cust_country) valueS(?,?,?,?,?)";
	private static final String deleteCustomerSQL = "DELETE FROM Customers where cust_id = ?";
	private static final String updateCustomerSQL = "UPDATE Customers SET cust_first_name=?, cust_last_name =?,cust_email=?, cust_city=?, cust_country=? where cust_id = ?";
	private static final String selectCustomerSQL = "SELECT cust_id,cust_first_name,cust_last_name, cust_email,cust_city,cust_country FROM customers WHERE cust_id = ?";
	private static final String selectAllCustomerSQL = "SELECT cust_id,cust_first_name,cust_last_name, cust_email,cust_city,cust_country FROM customers";

	public Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\BVEN00677310A:1433;DatabaseName=sampledb",
					"test01", "test1234");

		} catch (Exception e) {
			System.out.println("Exception Caught");
			e.printStackTrace();
		}

		return conn;
	}

	public void insertCustomer(Customer customer) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement statement = conn.prepareStatement(insertCustomerSQL);
		statement.setString(1, customer.getCust_first_name());
		statement.setString(2, customer.getCust_last_name());
		statement.setString(3, customer.getCust_email());
		statement.setString(4, customer.getCust_city());
		statement.setString(5, customer.getCust_country());
		statement.executeUpdate();
		conn.close();
	}

	public boolean updateCustomer(Customer customer) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement statement = conn.prepareStatement(updateCustomerSQL);
		statement.setString(1, customer.getCust_first_name());
		statement.setString(2, customer.getCust_last_name());
		statement.setString(3, customer.getCust_email());
		statement.setString(4, customer.getCust_city());
		statement.setString(5, customer.getCust_country());
		statement.setInt(6, customer.getCust_id());
		boolean result = statement.executeUpdate() > 0;
		conn.close();
		return result;
	}

	public boolean deleteCustomer(int custId) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement statement = conn.prepareStatement(deleteCustomerSQL);
		statement.setInt(1, custId);
		boolean result = statement.executeUpdate() > 0;
		conn.close();
		return result;
	}

	public Customer selectCustomer(int custId) throws SQLException {

		Customer customer = new Customer();
		Connection conn = getConnection();

		PreparedStatement statement = conn.prepareStatement(selectCustomerSQL);
		statement.setInt(1, custId);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			customer.setCust_id(result.getInt(1));
			customer.setCust_first_name(result.getString(2));
			customer.setCust_last_name(result.getString(3));
			customer.setCust_email(result.getString(4));
			customer.setCust_city(result.getString(5));
			customer.setCust_country(result.getString(6));
		}
        conn.close();
		return customer;
	}

	public List<Customer> selectAllCustomer() throws SQLException {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = getConnection();

		PreparedStatement statement = conn.prepareStatement(selectAllCustomerSQL);

		ResultSet result = statement.executeQuery();
		
		
		while (result.next()) {
			Customer customer = new Customer();
			customer.setCust_id(result.getInt(1));
			customer.setCust_first_name(result.getString(2));
			customer.setCust_last_name(result.getString(3));
			customer.setCust_email(result.getString(4));
			customer.setCust_city(result.getString(5));
			customer.setCust_country(result.getString(6));
			customerList.add(customer);
			//System.out.println(customer);
		}
		
		conn.close();

		return customerList;

	}
}
