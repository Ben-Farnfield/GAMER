package com.gamer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gamer.dao.DAOFactory;
import com.gamer.dao.ProductDAO;
import com.gamer.model.PageOfProducts;
import com.gamer.model.Product;

/**
 * 
 */
@WebServlet("/productDisplay")
public class ProductDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final int NUM_PROD_PER_PAGE = 9; // TODO move into web.xml
	
	private static final String HOME = "home";
	private static final String GAMES = "games";
	private static final String TOYS = "toys";
	private static final String SEARCH = "search";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDisplayController() { super(); }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse res)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doPost(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse res)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		
		String action = (String)req.getParameter("action");
		if (action == null) action = "";
		
		int pageNum;
		try {
			pageNum = Integer.parseInt(req.getParameter("n"));
		} catch (NumberFormatException e) {
			pageNum = 1;
		}
		
		String url = "/";
		
		switch (action) {
		case GAMES:
			if ((String)session.getAttribute("currentPage") != GAMES) {
				ProductDAO dao = DAOFactory.getInstance().getProductDAO();
				session.setAttribute("products", dao.findAllGames());
				session.setAttribute("currentPage", GAMES);
			}
			
			session.setAttribute("pageOfProducts", 
					buildPageOfProducts(pageNum, session));
			
			url += "Games.jsp";
			break;

		case TOYS:
			if ((String)session.getAttribute("currentPage") != TOYS) {
				ProductDAO dao = DAOFactory.getInstance().getProductDAO();
				session.setAttribute("products", dao.findAllToys());
				session.setAttribute("currentPage", TOYS);
			}
			
			session.setAttribute("pageOfProducts", 
					buildPageOfProducts(pageNum, session));
			
			url += "Toys.jsp";
			break;
			
		default:
			if ((String)session.getAttribute("currentPage") != HOME) {
				ProductDAO dao = DAOFactory.getInstance().getProductDAO();
				session.setAttribute("products", dao.findAllProducts());
				session.setAttribute("currentPage", HOME);
			}
			
			session.setAttribute("pageOfProducts", 
					buildPageOfProducts(pageNum, session));
			
			url += "Home.jsp";
			break;
		}
		getServletContext().getRequestDispatcher(url).forward(req, res);
	}
	
	public PageOfProducts buildPageOfProducts(int pageNum, 
			HttpSession session) {
		
		PageOfProducts pageOfProducts = new PageOfProducts();
		pageOfProducts.setPageNum(pageNum);
		pageOfProducts.setTotalNumPages(totalNumPages(session));
		pageOfProducts.setProducts(getProductsForPage(pageNum, session), session);
		return pageOfProducts;
	}
	
	public int getNumProducts(HttpSession session) {
		return ((ArrayList<Product>)session.getAttribute("products")).size();
	}
	
	public int totalNumPages(HttpSession session) {
		int numProds = getNumProducts(session);
				
		if (numProds % NUM_PROD_PER_PAGE == 0) {
			return numProds / NUM_PROD_PER_PAGE;
		}
		return (numProds / NUM_PROD_PER_PAGE) + 1;
	}
	
	public List<Product> getProductsForPage(int pageNum, 
			HttpSession session) {
		
		ArrayList<Product> products = 
				(ArrayList<Product>)session.getAttribute("products");
		
		int firstProduct = (pageNum - 1) * NUM_PROD_PER_PAGE;
		int lastProduct = firstProduct + NUM_PROD_PER_PAGE;
		
		try {
			return products.subList(firstProduct, lastProduct);
		} catch (IndexOutOfBoundsException e) {
			return products.subList(firstProduct, getNumProducts(session));
		}
	}
}
