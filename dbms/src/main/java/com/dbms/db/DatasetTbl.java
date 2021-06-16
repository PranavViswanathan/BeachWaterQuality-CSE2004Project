package com.dbms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbms.entity.Dataset;

public class DatasetTbl implements DatasetTblInterface {
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;

	@Override
	public ArrayList<Dataset> get(int limit, int offset) {
		ArrayList<Dataset> list = null;
		Dataset ds = null;
		
		try {
			
			list = new ArrayList<Dataset>();
			String sql = "SELECT id,Beach_Name,Wave_Period,Water_Temperature,Turbidity FROM dataset ORDER BY id LIMIT "+limit+" OFFSET "+offset;
			System.out.println("sql:"+sql);
			connection = ConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				ds = new Dataset();
				ds.setId(resultSet.getInt("id"));
				ds.setBeach_Name(resultSet.getString("Beach_Name"));
				ds.setWave_Period(resultSet.getDouble("Wave_Period"));
				ds.setWater_Temperature(resultSet.getDouble("Water_Temperature"));
				ds.setTurbidity(resultSet.getDouble("Turbidity"));
				list.add(ds);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Dataset get(int id) {

		
		Dataset ds = null;
		try {
			ds = new Dataset();
			String sql = "SELECT id,Beach_Name,Wave_Period,Water_Temperature,Turbidity FROM dataset where id="+id;
			connection = ConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				ds.setId(resultSet.getInt("id"));
				ds.setBeach_Name(resultSet.getString("Beach_Name"));
				ds.setWave_Period(resultSet.getDouble("Wave_Period"));
				ds.setWater_Temperature(resultSet.getDouble("Water_Temperature"));
				ds.setTurbidity(resultSet.getDouble("Turbidity"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public boolean update(Dataset ds) {
		boolean flag = false;
		try {
			String sql = String.format("UPDATE dataset SET Beach_Name ='%s', Wave_Period=%.2f, Water_Temperature= %.2f, Turbidity=%.2f where id=%d", 
					ds.getBeach_Name(), ds.getWave_Period(), ds.getWater_Temperature(), ds.getTurbidity(), ds.getId());
			System.out.println("Update sql:"+sql);
			connection = ConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
