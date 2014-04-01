package com.gamer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.gamer.model.Product;

public class ProductDAOImpl implements ProductDAO {

	private String url;
	private Properties prop;
	
	ProductDAOImpl(String url, Properties prop) {
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
	public ArrayList<Product> findAllProducts() {
		ArrayList<Product> products = new ArrayList<>();
		
		String sql = "SELECT * FROM product";
		
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				products.add(buildProduct(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) closeConnection(con);
		}		
		return products;
	}
	
	@Override
	public Product findProduct(int id) {
				
		String sql = "SELECT * FROM product WHERE productid='" + id + "'";
		
		Product product = null;
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			product = buildProduct(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) closeConnection(con);
		}		
		return product;
	}
	
	@Override
	public ArrayList<Product> findAllGames() {
		ArrayList<Product> products = new ArrayList<>();
		
		String sql = "SELECT * FROM product WHERE product_type='g'";
		
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				products.add(buildProduct(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) closeConnection(con);
		}		
		return products;
	}
	
	@Override
	public ArrayList<Product> findAllToys() {		
		return new ArrayList<>();
	}
	
	@Override
	public ArrayList<Product> searchByKeywords(String[] keywords) {
		ArrayList<Product> products = new ArrayList<>();
		
		if (keywords.length == 0) return products; 
		
		String sql = "SELECT * FROM product WHERE ";
		
		for (String keyword : keywords) {
			sql += "product_name ILIKE '%" + keyword 
					+ "%' OR genre ILIKE '%" + keyword 
					+ "%' OR description ILIKE '%" + keyword 
					+ "%' OR ";
		}
		
		sql = sql.substring(0, sql.length()-4) + ";"; // -4 to remove trailing OR
		
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				products.add(buildProduct(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) closeConnection(con);
		}		
		return products;
	}
	
	private Product buildProduct(ResultSet resultSet) throws SQLException {
		Product product = new Product();
		product.setName(resultSet.getString("product_name"));
		product.setPrice(resultSet.getDouble("price"));
		product.setDescription(resultSet.getString("description"));
		product.setGenre(resultSet.getString("genre"));
		product.setPictureURI(resultSet.getString("pic_url"));
		product.setStock(resultSet.getInt("stock"));
		product.setId(resultSet.getInt("productid"));
		product.setType(resultSet.getString("product_type"));
		return product;
	}
}
