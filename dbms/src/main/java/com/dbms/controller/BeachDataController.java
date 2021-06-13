package com.dbms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.db.DatasetTbl;
import com.dbms.db.DatasetTblInterface;
import com.dbms.entity.Dataset;

/**
 * Servlet implementation class BeachDataController
 */
public class BeachDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeachDataController() {
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
		int limit = 25;
		int offset = 0;
		if(request.getParameter("limit")!=null)
		{	
			limit = Integer.parseInt(request.getParameter("limit"));	
			offset = Integer.parseInt(request.getParameter("offset"));
			request.getSession().setAttribute("limit", 25);
			request.getSession().setAttribute("offset", 0);
		}else {		
			limit = (int)request.getSession().getAttribute("limit");	
			offset = (int)request.getSession().getAttribute("offset");
		}
		
		System.out.println("@BeachDataController: limit:"+limit);
		System.out.println("@BeachDataController: offset:"+offset);
		System.out.println("@BeachDataController: UserType:"+request.getSession().getAttribute("UserType"));
		
		DatasetTblInterface ds = new DatasetTbl();		
		ArrayList<Dataset> alDataset = ds.get(limit, offset);	
		
		for(int i=0; i<alDataset.size(); i++) {
			System.out.println(alDataset.get(i).toString());
		}		
		
		request.setAttribute("list", alDataset);		
		dispatcher = request.getRequestDispatcher("/views/BeachData.jsp");		
		dispatcher.forward(request, response);
	}

}
