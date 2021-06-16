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
 * Servlet implementation class UpdateBeachRecController
 */
public class UpdateReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReportController() {
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
		String rep = request.getParameter("report");
		String beach = request.getParameter("beachName");
		Reports rp = new Reports();
		rp.setReport(rep);
		rp.setBeachName(beach);
		System.out.println("@UpdateReportController: Reports:"+rp.toString());
		ReportsInterface reportDetails = new ReportsDtls();
		boolean result = reportDetails.save(rp);
		String reportInfo="";
		if (result) {
			System.out.println("Report added");
			reportInfo ="Report added";
		} else {
			System.out.println("Check added details");
			reportInfo ="Report not added";
		}
		request.getSession().setAttribute("reportInfo", reportInfo);
		dispatcher = request.getRequestDispatcher("views/MakeReport.jsp");
		dispatcher.forward(request,  response);
	}

}
