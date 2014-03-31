package com.gamer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamer.viewhelper.RegisterViewHelper;
import com.gamer.viewhelper.ViewHelperFactory;

/**
 * 
 */
@WebServlet("/registerController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {super();}

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
		
		String url = "/";
		
		String action = (String)req.getParameter("action");
		
		switch (action) {
		case "register":
			url += "Register.jsp";
			break;

		case "register-submit":
			RegisterViewHelper registerViewHelper = 
					ViewHelperFactory.getInstance().getRegisterViewHelper(req);
			
			if (registerViewHelper.isValidCustomerDetails()) {
				// Add cust to DB
				// Show Registered Page
				// NOTE cust email could be in DB, need to handle this
				System.out.println("Valid customer");
			} else {
				req.setAttribute("registerViewHelper", registerViewHelper);
				url += "RegisterSubmitted.jsp";
			}
			break;
		}
		
		getServletContext().getRequestDispatcher(url).forward(req, res);
	}
}