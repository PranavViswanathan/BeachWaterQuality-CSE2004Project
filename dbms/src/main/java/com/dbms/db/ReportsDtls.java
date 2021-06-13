package com.dbms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbms.entity.Dataset;
import com.dbms.entity.Reports;
import com.dbms.entity.User;

public class ReportsDtls implements ReportsInterface{
	
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	Connection connection = ConnectionUtil.openConnection();
	@Override
	public boolean save(Reports report) {
		boolean flag = false;
		try {
			
			String sql = String.format("INSERT INTO reports(id, report, beach) VALUES ('%d','%s','%s')", 
					report.getId(), report.getReport(), report.getBeachName());
			System.out.println("sql:"+sql);
			connection = ConnectionUtil.openConnection();
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public ArrayList<Reports> get(int limit, int offset) {
		ArrayList<Reports> list = null;
		Reports rp = null;
		
		try {
			
			list = new ArrayList<Reports>();
			String sql = "SELECT id,report, beach FROM reports ORDER BY id LIMIT "+limit+" OFFSET "+offset;
			System.out.println("sql:"+sql);
			connection = ConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				rp = new Reports();
				rp.setId(resultSet.getInt("id"));
				rp.setReport(resultSet.getString("report"));
				rp.setBeachName(resultSet.getString("beach"));
				list.add(rp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Reports get(int id) {
	
			
			Reports rp = null;
			try {
				rp = new Reports();
				String sql = "SELECT id,report, beach FROM reports where id="+id;
				connection = ConnectionUtil.openConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql);
				if(resultSet.next()) {
					rp.setId(resultSet.getInt("id"));
					rp.setReport(resultSet.getString("report"));
					rp.setBeachName(resultSet.getString("beachName"));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return rp;
		}
}
