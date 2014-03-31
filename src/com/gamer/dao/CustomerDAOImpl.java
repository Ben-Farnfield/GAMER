package com.gamer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.gamer.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	private String url;
	private Properties prop;
	
	CustomerDAOImpl(String url, Properties prop) {
		this.url = url;
		this.prop = prop;
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, prop);
	}
	
	private void closeConnection(Connection connection) {
		if (connection == null) return;
		try {
			connection.close();
		} catch (SQLException e) {}
	}
	
	@Override
	public boolean isEmailInDatabase(String email) {
		String sql = "SELECT * FROM customer WHERE email='" + email + "';";
		
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return true; // prompt user for password again
		} finally {
			if (con != null) closeConnection(con);
		}
	}
	
	@Override
	public void insertCustomer(Customer customer) {
		String sql = "INSERT INTO customer (forename, surname, house_no, "
				+ "street, postcode, email, balance, card_no, cust_password)"
				   + " VALUES ('" + customer.getForename() + "', '"
						          + customer.getSurname() + "', '"
						          + customer.getHouseNo() + "', '"
						          + customer.getStreet() + "', '"
						          + customer.getPostCode() + "', '"
						          + customer.getEmail() + "', "
						          + "'100', '"
						          + customer.getCardNum() + "', '"
						          + customer.getPassword() + "');";
		
		System.out.println(sql);
		
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) closeConnection(con);
		}
	}
}
