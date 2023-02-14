package com.pack.model;

public class JWTResponse {
	String token;
	String user;
	
	

	@Override
	public String toString() {
		return "JWTResponse [token=" + token + ", user=" + user + "]";
	}

	public JWTResponse() {
		super();
		
	}

	public JWTResponse(String token,String user) {
		super();
		this.token = token;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
	
}
