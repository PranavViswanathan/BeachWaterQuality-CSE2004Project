package com.dbms.entity;

public class Reports {
	private int id;
	private String report;
	private String beachName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getBeachName() {
		return beachName;
	}
	public void setBeachName(String beachName) {
		this.beachName = beachName;
	}
	
	@Override
	public  String toString() {
		return String.format("{id:%d, report:%s, beachName:%s}", id, report, beachName);
	}

}
