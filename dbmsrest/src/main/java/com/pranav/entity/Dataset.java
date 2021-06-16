package com.pranav.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dataset {
	private int id;
	private String beach_Name;
	private double wave_Period;
	private double water_Temperature;
	private double turbidity;	
	//Unused in updates
	private String measurement_Timestamp;
	private double transducer_Depth;
	private double wave_Height;
	private double battery_Life;
	private String measurement_Timestamp_Label;
	private String measurement_ID; 
	
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
	
	//Unused in updates
	public String getMeasurement_Timestamp() {
		return measurement_Timestamp;
	}
	public void setMeasurement_Timestamp(String measurement_Timestamp) {
		this.measurement_Timestamp = measurement_Timestamp;
	}
	public double getTransducer_Depth() {
		return transducer_Depth;
	}
	public void setTransducer_Depth(double transducer_Depth) {
		this.transducer_Depth = transducer_Depth;
	}
	public double getWave_Height() {
		return wave_Height;
	}
	public void setWave_Height(double wave_Height) {
		this.wave_Height = wave_Height;
	}
	public double getBattery_Life() {
		return battery_Life;
	}
	public void setBattery_Life(double battery_Life) {
		this.battery_Life = battery_Life;
	}
	public String getMeasurement_Timestamp_Label() {
		return measurement_Timestamp_Label;
	}
	public void setMeasurement_Timestamp_Label(String measurement_Timestamp_Label) {
		this.measurement_Timestamp_Label = measurement_Timestamp_Label;
	}
	public String getMeasurement_ID() {
		return measurement_ID;
	}
	public void setMeasurement_ID(String measurement_ID) {
		this.measurement_ID = measurement_ID;
	}
	
	@Override
	public String toString() {
		return String.format("{id:%d, beach_Name:%s, wave_Period:%.2f, water_Temperature:%.2f, turbidity:%.2f}", id,beach_Name,wave_Period,water_Temperature,turbidity);
	}
}
