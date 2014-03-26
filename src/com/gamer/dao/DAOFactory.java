package com.gamer.dao;

import java.util.Properties;


public class DAOFactory {
	
	private static DAOFactory daoFactory;
	
	// TODO move out into properties file
	private static final String USER_NAME = "postgres";
	private static final String PASSWORD = "C4tf1sh10";
	private static final String URL = "jdbc:postgresql://localhost/postgres";
	
	private static final Properties PROP = new Properties();
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			
			PROP.setProperty("user", USER_NAME);
			PROP.setProperty("password", PASSWORD);
			
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(-1);
		}
	}

	private DAOFactory() {}
	
	public static synchronized DAOFactory getInstance() {
		if (daoFactory == null) daoFactory = new DAOFactory();
		return daoFactory;
	}
	
	public ProductDAO getProductDAO() {
		return (ProductDAO) new ProductDAOImpl(URL, PROP);
	}
}
