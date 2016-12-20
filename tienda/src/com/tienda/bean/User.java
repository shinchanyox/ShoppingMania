package com.tienda.bean;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="user")
public class User {
	
	private int userId ;
	private String username,email  ;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(int userId, String username, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
	}
	public User() {
		super();
	}
	
	

}
