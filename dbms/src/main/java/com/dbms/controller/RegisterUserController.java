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
 * Servlet implementation class RegisterUserController
 */
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserController() {
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
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");

		User user = new User();
		user.setNameu(name);
		user.setEmail(email);
		user.setPwd(pwd);
		if(request.getParameter("admin")!=null) {
			user.setAdminUser(true);
		}
		else {
			user.setAdminUser(false);
		}
		System.out.println("@RegisteUserController: User:"+user.toString());
		
		UserDtlsInterface userDtls = new UserDtls();
		boolean result = userDtls.save(user);
		String info="";
		if(result) {
			info = "User Added Successfuly";
		}else {
			info = "Error adding user:"+user.toString();
		}
		request.getSession().setAttribute("info", info);
		dispatcher = request.getRequestDispatcher("/views/RegisterUser.jsp");		
		dispatcher.forward(request, response);
	}

}
