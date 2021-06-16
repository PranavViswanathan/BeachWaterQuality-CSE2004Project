package com.dbms.db;

import java.util.ArrayList;

import com.dbms.entity.Reports;

public interface ReportsInterface {
	boolean save(Reports report);
	public ArrayList<Reports> get(int limit, int offset);
	public Reports get(int id);

}
