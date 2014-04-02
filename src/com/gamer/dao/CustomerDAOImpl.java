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
	public boolean emailPasswordComboIsInDatabase(String email, String password) {
		String sql = "SELECT * FROM customer WHERE email='" + email 
				+ "' AND cust_password='" + password + "';";
		
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) closeConnection(con);
		}
	}
	
	@Override
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT * FROM customer WHERE email='" + email + "';";
		
		Connection con = null;
		Customer customer = null;
		try {
			con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) customer = buildCustomer(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) closeConnection(con);
		}
		return customer;
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
						          + customer.getEmail() + "', '"
						          + customer.getBalance() + "', '"
						          + customer.getCardNum() + "', '"
						          + customer.getPassword() + "');";
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
	
	@Override
	public double findCustomersBalance(int id) {
		double customersBalance = 0;
		
		String sql = "SELECT balance FROM customer WHERE customer_id='" + id + "';";
		
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				customersBalance = resultSet.getDouble("balance");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) closeConnection(con);
		}
		
		return customersBalance;
	}
	
	@Override
	public void decreaseBalance(int id, double amount) {
		double balance = findCustomersBalance(id) - amount;
		String sql = "UPDATE customer SET balance='" + balance 
				+ "' WHERE customer_id='" + id + "';";
		
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
	
	private Customer buildCustomer(ResultSet resultSet) throws SQLException {
		Customer customer = new Customer();
		customer.setBalance(resultSet.getDouble("balance"));
		customer.setCardNum(resultSet.getLong("card_no"));
		customer.setEmail(resultSet.getString("email"));
		customer.setForename(resultSet.getString("forename"));
		customer.setHouseNo(resultSet.getInt("house_no"));
		customer.setId(resultSet.getInt("customer_id"));
		customer.setPostCode(resultSet.getString("postcode"));
		customer.setStreet(resultSet.getString("street"));
		customer.setSurname(resultSet.getString("surname"));
		customer.setPassword("No Need For This!");
		return customer;
	}
}
