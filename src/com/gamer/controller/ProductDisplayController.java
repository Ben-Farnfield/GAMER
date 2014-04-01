package com.gamer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamer.viewhelper.ProductViewHelper;
import com.gamer.viewhelper.ViewHelperFactory;

/**
 * 
 */
@WebServlet("/productDisplay")
public class ProductDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		
		String action = (String)req.getParameter("action");
		if (action == null) action = "";
		
		ProductViewHelper productViewHelper;
		
		String url = "/";
		
		switch (action) {
		case GAMES:
			productViewHelper = ViewHelperFactory.getInstance()
					.getProductViewHelper(ViewHelperFactory.GAMES, req);
			req.setAttribute("productViewHelper", productViewHelper);
			
			url += "Games.jsp";
			break;

		case TOYS:
			productViewHelper = ViewHelperFactory.getInstance()
					.getProductViewHelper(ViewHelperFactory.TOYS, req);
			req.setAttribute("productViewHelper", productViewHelper);
			
			url += "Toys.jsp";
			break;
			
		case SEARCH:
			productViewHelper = ViewHelperFactory.getInstance()
					.getSearchProductViewHelper(req);
			req.setAttribute("productViewHelper", productViewHelper);
			
			url += "Search.jsp";		
			break;
			
		default:
			productViewHelper = ViewHelperFactory.getInstance()
					.getProductViewHelper(ViewHelperFactory.HOME, req);
			req.setAttribute("productViewHelper", productViewHelper);
			
			url += "Home.jsp";
			break;
		}
		getServletContext().getRequestDispatcher(url).forward(req, res);
	}
}
