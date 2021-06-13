package com.dbms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbms.db.DatasetTbl;
import com.dbms.db.DatasetTblInterface;
import com.dbms.entity.Dataset;

/**
 * Servlet implementation class UpdateBeachRecController
 */
public class UpdateBeachRecController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBeachRecController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String when = request.getParameter("when");
		System.out.println("when:"+when);
		DatasetTblInterface dsTbl = new DatasetTbl();
		if(when.equals("beforeUpdate")) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("id:"+id);
			
			
			Dataset ds = dsTbl.get(id);
			System.out.println(ds.toString());
			
			request.setAttribute("dataset", ds);
			
			dispatcher = request.getRequestDispatcher("/views/UpdateBeachRec.jsp");		
			dispatcher.forward(request, response);
		}else if(when.equals("afterUpdae")) {
			Dataset ds = new Dataset();
			int id = Integer.parseInt(request.getParameter("id"));
			ds.setId(id);
			ds.setBeach_Name(request.getParameter("Beach_Name"));
			ds.setWave_Period(Double.parseDouble(request.getParameter("Wave_Period")));
			ds.setWater_Temperature(Double.parseDouble(request.getParameter("Water_Temperature")));
			ds.setTurbidity(Double.parseDouble(request.getParameter("Turbidity")));
			System.out.println("Dataset after update: "+ds.toString());
			boolean bResult = dsTbl.update(ds);
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
