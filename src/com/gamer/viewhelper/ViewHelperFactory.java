package com.gamer.viewhelper;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.gamer.dao.DAOFactory;
import com.gamer.dao.ProductDAO;
import com.gamer.model.Basket;
import com.gamer.model.Product;

public class ViewHelperFactory {
	
	public static final String HOME = "home";
	public static final String TOYS = "toys";
	public static final String GAMES = "games";

	private static ViewHelperFactory viewHelperFactory;
	
	private ViewHelperFactory() {}
	
	public static synchronized ViewHelperFactory getInstance() {
		if (viewHelperFactory == null) {
			viewHelperFactory = new ViewHelperFactory();
		}
		return viewHelperFactory;
	}
	
	public RegisterViewHelper getRegisterViewHelper(HttpServletRequest req) 
			throws UnsupportedEncodingException {
		
		RegisterViewHelper registerViewHelper = new RegisterViewHelper();
		
		if (req.getParameter("forename") != null) {
			registerViewHelper.setForename(new String(req.getParameter("forename")
					.getBytes("iso-8859-1"), "UTF-8"));
		}
		if (req.getParameter("surname") != null) {
			registerViewHelper.setSurname(new String(req.getParameter("surname")
					.getBytes("iso-8859-1"), "UTF-8"));
		}
		if (req.getParameter("email") != null) {
			registerViewHelper.setEmail(new String(req.getParameter("email")
					.getBytes("iso-8859-1"), "UTF-8"));
		}
		if (req.getParameter("password") != null) {
			registerViewHelper.setPassword(new String(req.getParameter("password")
					.getBytes("iso-8859-1"), "UTF-8"));
		}
		if (req.getParameter("conf-password") != null) {
			registerViewHelper.setConfPassword(new String(req.getParameter("conf-password")
					.getBytes("iso-8859-1"), "UTF-8"));
		}
		if (req.getParameter("card-num") != null) {
			registerViewHelper.setCardNum(new String(req.getParameter("card-num")
					.getBytes("iso-8859-1"), "UTF-8"));
		}
		if (req.getParameter("house-num") != null) {
			registerViewHelper.setHouseNum(new String(req.getParameter("house-num")
					.getBytes("iso-8859-1"), "UTF-8"));
		}
		if (req.getParameter("street") != null) {
			registerViewHelper.setStreet(new String(req.getParameter("street")
					.getBytes("iso-8859-1"), "UTF-8"));
		}
		if (req.getParameter("postcode") != null) {
			registerViewHelper.setPostcode(new String(req.getParameter("postcode")
					.getBytes("iso-8859-1"), "UTF-8"));
		}
		
		return registerViewHelper;
	}
	
	public LoginViewHelper getLoginViewHelper(HttpServletRequest req)
			throws UnsupportedEncodingException {
		
		LoginViewHelper loginViewHelper = new LoginViewHelper();
		
		if (req.getParameter("email") != null) {
			loginViewHelper.setEmail(new String(req.getParameter("email")
					.getBytes("iso-8859-1"), "UTF-8"));
		}
		if (req.getParameter("password") != null) {
			loginViewHelper.setPassword(new String(req.getParameter("password")
					.getBytes("iso-8859-1"), "UTF-8"));
		}
		
		return loginViewHelper;
	}
	
	public ProductViewHelper getSearchProductViewHelper(HttpServletRequest req) 
			throws UnsupportedEncodingException {
		
		ProductViewHelper productViewHelper = new ProductViewHelper();
		
		if (req.getParameter("n") != null) {
			productViewHelper.setCurrentPage(
					Integer.parseInt(req.getParameter("n")));
		}
		else {
			productViewHelper.setCurrentPage(1);
		}
		
		if (req.getParameter("keywords") != null) {
			
			String keywordString = new String(req.getParameter("keywords")
					.getBytes("iso-8859-1"), "UTF-8");
			String[] keywords = keywordString.split("\\s");
			
			ArrayList<Product> products = DAOFactory.getInstance()
					.getProductDAO().searchByKeywords(keywords);
			
			Basket basket = (Basket)req.getSession().getAttribute("basket");
			
			productViewHelper.setProducts(products, basket);
		}
		else {
			productViewHelper.setProducts(new ArrayList<Product>(), null);
		}
		
		return productViewHelper;
	}
	
	public ProductViewHelper getProductViewHelper(
			String page, HttpServletRequest req) {
		
		ProductViewHelper productViewHelper = new ProductViewHelper();
		
		if (req.getParameter("n") != null) {
			productViewHelper.setCurrentPage(
					Integer.parseInt(req.getParameter("n")));
		}
		else {
			productViewHelper.setCurrentPage(1);
		}
		
		ArrayList<Product> products = null;
		ProductDAO dao = DAOFactory.getInstance().getProductDAO();
		switch (page) {
		case HOME:
			products = dao.findAllProducts();
			break;

		case TOYS:
			products = dao.findAllToys();
			break;
			
		case GAMES:
			products = dao.findAllGames();
			break;
		}

		Basket basket = (Basket)req.getSession().getAttribute("basket");
		
		productViewHelper.setProducts(products, basket);
		
		return productViewHelper;
	}
}
