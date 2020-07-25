package com.harshareddy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.harshareddy.model.User;

public class UserDAO {

	private static final String insertUserSQL = "INSERT INTO Users(name, email, country) values(?,?,?)";
	private static final String deleteUserSQL = "DELETE FROM Users where id = ?";
	private static final String updateUserSQL = "UPDATE Users SET name=?, email=?, country=? where id = ?";
	private static final String selectUserSQL = "SELECT * FROM Users WHERE id = ?";
	private static final String selectAllUserSQL = "SELECT * FROM Users";

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

	public void insertUser(User user) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement statement = conn.prepareStatement(insertUserSQL);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getCountry());
		statement.executeUpdate();
		conn.close();
	}

	public boolean updateUser(User user) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement statement = conn.prepareStatement(updateUserSQL);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getCountry());
		statement.setInt(4, user.getId());
		boolean result = statement.executeUpdate() > 0;
		conn.close();
		return result;

	}

	public boolean deleteUser(int id) throws SQLException {

		Connection conn = getConnection();
		PreparedStatement statement = conn.prepareStatement(deleteUserSQL);
		statement.setInt(1, id);
		boolean result = statement.executeUpdate() > 0;
		conn.close();
		return result;
	}

	public User selectUser(int id) throws SQLException {

		User user = new User();
		Connection conn = getConnection();

		PreparedStatement statement = conn.prepareStatement(selectUserSQL);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			user.setId(result.getInt(1));
			user.setName(result.getString(2));
			user.setEmail(result.getString(3));
			user.setCountry(result.getString(4));

		}

		return user;
	}

	public List<User> selectAllUser() throws SQLException {
		List<User> userList = new ArrayList<User>();
		Connection conn = getConnection();

		PreparedStatement statement = conn.prepareStatement(selectAllUserSQL);

		ResultSet result = statement.executeQuery();

		while (result.next()) {
			User user = new User();

			user.setId(result.getInt(1));
			user.setName(result.getString(2));
			user.setEmail(result.getString(3));
			user.setCountry(result.getString(4));

			userList.add(user);

		}

		return userList;

	}
}
