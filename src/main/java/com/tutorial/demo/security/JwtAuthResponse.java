package com.tutorial.demo.security;

public class JwtAuthResponse {

	private String token;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public JwtAuthResponse(String token) {
		this.token = token;
	}

	public JwtAuthResponse() {}
	
	
}
