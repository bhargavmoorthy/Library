package com.app.library.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Libusers {
	@Id @GeneratedValue
	private int userid;
	private String Username;
	private String Password;
	private String UserRole;
	
	public Libusers() {
		
	}
	
	public Libusers(int userid, String username, String password, String userRole) {
		super();
		this.userid = userid;
		Username = username;
		Password = password;
		UserRole = userRole;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String userRole) {
		UserRole = userRole;
	}
	

}
