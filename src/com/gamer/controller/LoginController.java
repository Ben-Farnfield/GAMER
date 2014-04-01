package com.gamer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gamer.dao.DAOFactory;
import com.gamer.model.Customer;
import com.gamer.viewhelper.LoginViewHelper;
import com.gamer.viewhelper.ViewHelperFactory;

/**
 * 
 */
@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {super();}

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
		
		String url = "/";
		
		String action = (String)req.getParameter("action");
		
		LoginViewHelper loginViewHelper = 
				ViewHelperFactory.getInstance().getLoginViewHelper(req);
		req.setAttribute("loginViewHelper", loginViewHelper);
		
		switch (action) {
		case "login":
			url += "Login.jsp";
			break;

		case "login-submit":
			if (loginViewHelper.containsValidLoginDetails()
					&& loginViewHelper.emailPasswordComboIsInDatabase()) {
				Customer customer = DAOFactory.getInstance().getCustomerDAO()
						.findCustomerByEmail(loginViewHelper.getEmail());
				session.setAttribute("loggedInCustomer", customer);
				
				if ("purchase".equals(req.getParameter("requestAction"))) {
					url += "purchaseController";
				}
				else {
					url += "LoginSuccessful.jsp";
				}
			}
			else {
				if ("purchase".equals(req.getParameter("requestAction"))) {
					req.setAttribute("requestAction", "purchase");
				}
				url += "LoginSubmitted.jsp";
			}
			break;
		}
		
		getServletContext().getRequestDispatcher(url).forward(req, res);
	}
}
