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

	public ArrayList<Product> findAllProducts() {
		ArrayList<Product> products = new ArrayList<>();
		
		String sql = "SELECT * FROM product";
		
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setDescription(resultSet.getString("description"));
				product.setGenre(resultSet.getString("genre"));
				product.setPictureURI(resultSet.getString("pic_url"));
				product.setQuantity(resultSet.getInt("stock"));
				product.setId(resultSet.getInt("productid"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) closeConnection(con);
		}		
		return products;
	}
	
	public Product findProduct(int id) {
		Product product = new Product();
		
		String sql = "SELECT * FROM product WHERE productid='" + id + "'";
		
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			product.setName(resultSet.getString("product_name"));
			product.setPrice(resultSet.getDouble("price"));
			product.setDescription(resultSet.getString("description"));
			product.setGenre(resultSet.getString("genre"));
			product.setPictureURI(resultSet.getString("pic_url"));
			product.setQuantity(resultSet.getInt("stock"));
			product.setId(resultSet.getInt("productid"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) closeConnection(con);
		}		
		return product;
	}
	
	public ArrayList<Product> findAllGames() {
		ArrayList<Product> products = new ArrayList<>();
		
		String sql = "SELECT * FROM product WHERE product_type='g'";
		
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setDescription(resultSet.getString("description"));
				product.setGenre(resultSet.getString("genre"));
				product.setPictureURI(resultSet.getString("pic_url"));
				product.setQuantity(resultSet.getInt("stock"));
				product.setId(resultSet.getInt("productid"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) closeConnection(con);
		}		
		return products;
	}
	
	public ArrayList<Product> findAllToys() {		
		return new ArrayList<>();
	}
	
	public ArrayList<Product> searchByKeywords(String[] keywords) {
		return new ArrayList<>();
	}
}
