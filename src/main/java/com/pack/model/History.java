package com.pack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class History {
	@Id
	private String id;
	private String userId;
	private String geoLocation;
	private String loginTime;
	private String logoutTime;
	private String token;
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	public History(String id, String userId, String geoLocation, String loginTime, String logoutTime,String token) {
		super();
		this.id = id;
		this.userId = userId;
		this.geoLocation = geoLocation;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.token = token;
	}
	public History() {
		super();
		// TODO Auto-generated constructor stub
	}
}
