package com.dbms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.db.ReportsDtls;
import com.dbms.db.ReportsInterface;
import com.dbms.entity.Reports;

/**
 * Servlet implementation class ViewReportsController
 */
public class ViewReportsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReportsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("@ViewReportsController");
		ReportsInterface r = new ReportsDtls();
		ArrayList<Reports> reportsList = r.get(1000, 0);
		for (int i = 0; i < reportsList.size(); i++) {
			System.out.println(reportsList.get(i).toString());
		}
		request.setAttribute("reportsList", reportsList);
		dispatcher = request.getRequestDispatcher("views/ViewReports.jsp");
		dispatcher.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
