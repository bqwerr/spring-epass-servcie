package com.project.travelpass.services;

import java.time.Instant;


public class AuthenticationResponse {
   
	private String authenticationToken;
    private String uid;
    private String refreshToken;
	private Instant expiresAt;
	
	public AuthenticationResponse(String authenticationToken, String uid, String refreshToken, Instant expiresAt) {
		super();
		this.authenticationToken = authenticationToken;
		this.uid = uid;
		this.refreshToken = refreshToken;
		this.expiresAt = expiresAt;
	}
   
	public String getAuthenticationToken() {
		return authenticationToken;
	}
	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	  public String getRefreshToken() {
			return refreshToken;
		}
		public void setRefreshToken(String refreshToken) {
			this.refreshToken = refreshToken;
		}
		public Instant getExpiresAt() {
			return expiresAt;
		}
		public void setExpiresAt(Instant expiresAt) {
			this.expiresAt = expiresAt;
		}
	
	
}
