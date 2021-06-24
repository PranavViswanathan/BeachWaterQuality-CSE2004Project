package com.pranav.entity;

public class User {
	private int id;
	private String nameu;
	private String email;
	private String pwd;
	private boolean isAdminUser;
	private boolean wantsAdminPrev =false;
	
	
	public boolean actAdmin() {
		if(isAdminUser && wantsAdminPrev) {
			return true;
		}
		return false;
	}


	public boolean isWantsAdminPrev() {
		return wantsAdminPrev;
	}


	public void setWantsAdminPrev(boolean wantsAdminPrev) {
		this.wantsAdminPrev = wantsAdminPrev;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNameu() {
		return nameu;
	}


	public void setNameu(String nameu) {
		this.nameu = nameu;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public boolean isAdminUser() {
		return isAdminUser;
	}


	public void setAdminUser(boolean isAdminUser) {
		this.isAdminUser = isAdminUser;
	}


	@Override
	public String toString() {
		return String.format("{id:%d, name:%s, email:%s, pwd:%s, isAdminUser?:%b, wantsAdminPrev?:%b, actAdmin:%b}", id,nameu,email,pwd, isAdminUser, wantsAdminPrev, actAdmin());
	}
}
