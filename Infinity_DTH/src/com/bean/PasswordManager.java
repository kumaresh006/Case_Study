package com.bean;

public class PasswordManager {
	private String userName;
	private String password;
	private int loginStatus;
	private int id;
	
	public PasswordManager(int id, String userName, String password, int loginStatus) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.loginStatus = loginStatus;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
}
