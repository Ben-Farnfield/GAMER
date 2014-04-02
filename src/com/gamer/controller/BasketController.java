package com.gamer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamer.model.Basket;
import com.gamer.viewhelper.BasketViewHelper;
import com.gamer.viewhelper.ViewHelperFactory;

/**
 * 
 */
@WebServlet("/basketController")
public class BasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketController() { super(); }

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

		if (req.getSession().getAttribute("basket") == null) {
			req.getSession().setAttribute("basket", new Basket());
		}
		
		BasketViewHelper basketViewHelper = 
				ViewHelperFactory.getInstance().getBasketViewHelper(req);
		
		String json;
		
		switch (action) {
		case "basket":
			String url = "/";
			if (basketViewHelper.basketIsEmpty()) {
				req.setAttribute("msg", "There are currently no items in your basket");
				req.setAttribute("link", "back to "
						+ "<a href=\"/GAMER/shop?action=home\">shopping</a>");
				url += "UserMsg.jsp";
			}
			else {
				url += "Basket.jsp";
			}
			getServletContext().getRequestDispatcher(url).forward(req, res);
			break;
		
		case "add-to-basket":
			json = basketViewHelper.addOneToBasket();
				
			res.setContentType("application/json");
		    res.setCharacterEncoding("UTF-8");
		    res.getWriter().write(json);
			break;

		case "rem-from-basket":
			json = basketViewHelper.removeOneFromBasket();
				
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(json);
			break;
			
		case "del-from-basket":
			json = basketViewHelper.removeAllFromBasket();
				
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(json);
			break;
		}
	}
}
