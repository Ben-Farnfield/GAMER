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
		
		HttpSession session = req.getSession(true);
		
		String url = "/";
		
		String action = (String)req.getParameter("action");
		
		RegisterViewHelper registerViewHelper = 
				ViewHelperFactory.getInstance().getRegisterViewHelper(req);
		req.setAttribute("registerViewHelper", registerViewHelper);
		
		switch (action) {
		case "register":
			url += "Register.jsp";
			break;

		case "register-submit":
			if (registerViewHelper.containsValidCustomerDetails()
					&& !registerViewHelper.isEmailInDatabase()) {

				Customer customer = registerViewHelper.createCustomer();
				DAOFactory.getInstance().getCustomerDAO()
						.insertCustomer(customer);
				session.setAttribute("loggedInCustomer", customer);
				
				if ("purchase".equals(req.getParameter("requestAction"))) {
					url += "purchaseController";
				}
				else {
					req.setAttribute("msg", "Hi " + customer.getForename() 
							+ ", welcome to GAMER.com !");
					req.setAttribute("link", "start shopping "
							+ "<a href=\"/GAMER/shop?action=home\">here</a>");
					url += "UserMsg.jsp";
				}
			} 
			else {
				if ("purchase".equals(req.getParameter("requestAction"))) {
					req.setAttribute("requestAction", "purchase");
				}
				url += "RegisterSubmitted.jsp";
			}
			break;
		}
		
		getServletContext().getRequestDispatcher(url).forward(req, res);
	}
}
