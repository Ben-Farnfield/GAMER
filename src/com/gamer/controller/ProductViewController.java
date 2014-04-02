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
public class ProductViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductViewController() { super(); }

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
		
		String url = "/ProductView.jsp";
		
		switch (action) {
		case ViewHelperFactory.GAMES:
			productViewHelper = ViewHelperFactory.getInstance()
					.getProductViewHelper(ViewHelperFactory.GAMES, req);
			req.setAttribute("productViewHelper", productViewHelper);
			req.setAttribute("productViewType", ViewHelperFactory.GAMES);
			break;

		case ViewHelperFactory.TOYS:
			productViewHelper = ViewHelperFactory.getInstance()
					.getProductViewHelper(ViewHelperFactory.TOYS, req);
			req.setAttribute("productViewHelper", productViewHelper);
			req.setAttribute("productViewType", ViewHelperFactory.TOYS);
			break;
			
		case ViewHelperFactory.SEARCH:
			
			productViewHelper = ViewHelperFactory.getInstance()
					.getProductViewHelper(ViewHelperFactory.SEARCH, req);
			
			if (productViewHelper.getProducts().size() == 0) {
				req.setAttribute("msg", "sorry, no results found for \"" 
						+ productViewHelper.getKeyword() + "\"");
				req.setAttribute("link", "back to "
							+ "<a href=\"/GAMER/shop?action=home\">shopping</a>");
				url = "/UserMsg.jsp";
			}
			else {
				req.setAttribute("productViewHelper", productViewHelper);
				req.setAttribute("productViewType", ViewHelperFactory.SEARCH);
			}
			break;
			
		default:
			productViewHelper = ViewHelperFactory.getInstance()
					.getProductViewHelper(ViewHelperFactory.HOME, req);
			req.setAttribute("productViewHelper", productViewHelper);
			req.setAttribute("productViewType", ViewHelperFactory.HOME);
			break;
		}
		getServletContext().getRequestDispatcher(url).forward(req, res);
	}
}
