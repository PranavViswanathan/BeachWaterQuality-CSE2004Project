package com.dbms.controller;

import java.io.IOException;

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
		String when = request.getParameter("when");
		System.out.println("when:"+when);
		ReportsInterface rp = new ReportsDtls();
		if(when.equals("beforeUpdate")) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("id:"+id);
			
			
			Reports report = rp.get(id);
			System.out.println(rp.toString());
			
			request.setAttribute("report", rp);
			
			dispatcher = request.getRequestDispatcher("/views/BeachData.jsp");		
			dispatcher.forward(request, response);
		}else if(when.equals("afterUpdae")) {
			Reports r = new Reports();
			int id = Integer.parseInt(request.getParameter("id"));
			r.setId(id);
			r.setBeachName(request.getParameter("beachName"));
			r.setReport(request.getParameter("reportInfo"));
			System.out.println("Dataset after update: "+r.toString());
			boolean bResult = rp.save(r);
			System.out.println("bResult:"+bResult);
			

			request.getSession().setAttribute("offset", id-1);
			
			dispatcher = request.getRequestDispatcher("BeachDataController");		
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
