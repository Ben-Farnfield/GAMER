package com.gamer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
@WebServlet(value="/shop")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() { super(); }

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
		
		req.getSession(true);
		
		String action = (String)req.getParameter("action");
		if (action == null) action = "";
		
		String url = "/";
		
		switch (action) {
		
		case "purchase":
			url += "purchaseController";
			break;
			
		case "login":
		case "login-submit":
			url += "loginController";
			break;
			
		case "logout":
			url += "logoutController";
			break;
			
		case "register":
		case "register-submit":
			url += "registerController";
			break;
			
		case "basket":
		case "add-to-basket":
		case "rem-from-basket":
		case "del-from-basket":
			url += "basketController";
			break;
			
		case "games":
		case "toys":
		case "search":
		default:
			url += "productDisplay";
			break;
		}
		getServletContext().getRequestDispatcher(url).forward(req, res);
	}
}
