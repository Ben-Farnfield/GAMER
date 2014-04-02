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
		
		String sql = "SELECT * FROM product";
		
		return queryForProducts(sql);
	}
	
	@Override
	public Product findProduct(int id) {
				
		String sql = "SELECT * FROM product WHERE productid='" + id + "';";
		
		return queryForProduct(sql);
	}
	
	@Override
	public int findProductStock(int id) {
		Product product = findProduct(id);
		
		return product.getStock();
	}
	
	@Override
	public ArrayList<Product> findAllGames() {
		
		String sql = "SELECT * FROM product WHERE product_type='g';";
		
		return queryForProducts(sql);
	}
	
	@Override
	public ArrayList<Product> findAllToys() {
		
		String sql = "SELECT * FROM product WHERE product_type='t';";
		
		return queryForProducts(sql);
	}
	
	@Override
	public ArrayList<Product> searchByKeywords(String[] keywords) {
		
		if (keywords.length == 0) return new ArrayList<Product>(); 
		
		// TODO there must be a better way !
		String sql = "SELECT * FROM product WHERE ";
		
		for (String keyword : keywords) {
			sql += "product_name ILIKE '%" + keyword 
					+ "%' OR genre ILIKE '%" + keyword 
					+ "%' OR description ILIKE '%" + keyword 
					+ "%' OR ";
		}
		
		sql = sql.substring(0, sql.length()-4) + ";"; // -4 to remove trailing OR
		// ---------------------------------
		
		return queryForProducts(sql);
	}
	
	@Override
	public void decreaseStock(int id, int amount) {
		
		int stock = findProductStock(id) - amount;
		String sql = "UPDATE product SET stock='" + stock 
				+ "' WHERE productid='" + id + "';";
		
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
	
	private Product queryForProduct(String sql) {
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
	
	private ArrayList<Product> queryForProducts(String sql) {
		ArrayList<Product> products = new ArrayList<>();
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
