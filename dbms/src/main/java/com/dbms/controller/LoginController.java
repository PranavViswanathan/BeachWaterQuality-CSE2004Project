package com.dbms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.db.UserDtls;
import com.dbms.db.UserDtlsInterface;
import com.dbms.entity.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String wantsAdmin = request.getParameter("wantsAdmin");
		System.out.println(String.format("{email:%s. pwd:%s, wantsAdmin:%s}",email,pwd,wantsAdmin));
		UserDtlsInterface userDtls = new UserDtls();
		User user = userDtls.getUser(email, pwd);
		if(user!=null) {
			if(wantsAdmin.equals("admin")) {
				System.out.println("setting wantsAdminPrev as True");
				user.setWantsAdminPrev(true);
			}else {
				System.out.println("setting wantsAdminPrev as False");
				user.setWantsAdminPrev(false);
			}
			request.getSession().setAttribute("info", "");
			System.out.println(user.toString());
			boolean bActAdmin = user.actAdmin();
			System.out.println("@LoginController: bActAdmin:"+bActAdmin);

			if(bActAdmin) {
				request.getSession().setAttribute("UserType", "Admin");
			}else {
				request.getSession().setAttribute("UserType", "User");
			}
			request.getSession().setAttribute("limit", 25);
			request.getSession().setAttribute("offset", 0);
			dispatcher = request.getRequestDispatcher("BeachDataController");		
			dispatcher.forward(request, response);

		}else {
			String info="User does not exist. Please Register first";
			request.getSession().setAttribute("info", info);
			dispatcher = request.getRequestDispatcher("/Login.jsp");		
			dispatcher.forward(request, response);
		}
	}

}
