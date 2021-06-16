package com.dbms.entity;

public class Dataset {
	private int id;
	private String beach_Name;
	private double wave_Period;
	private double water_Temperature;
	private double turbidity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBeach_Name() {
		return beach_Name;
	}
	public void setBeach_Name(String beach_Name) {
		this.beach_Name = beach_Name;
	}
	public double getWave_Period() {
		return wave_Period;
	}
	public void setWave_Period(double wave_Period) {
		this.wave_Period = wave_Period;
	}
	public double getWater_Temperature() {
		return water_Temperature;
	}
	public void setWater_Temperature(double water_Temperature) {
		this.water_Temperature = water_Temperature;
	}
	public double getTurbidity() {
		return turbidity;
	}
	public void setTurbidity(double turbidity) {
		this.turbidity = turbidity;
	}
	
	@Override
	public String toString() {
		return String.format("{id:%d, beach_Name:%s, wave_Period:%.2f, water_Temperature:%.2f, turbidity:%.2f}", id,beach_Name,wave_Period,water_Temperature,turbidity);
	}
}
