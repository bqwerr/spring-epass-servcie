package com.project.travelpass.dto;

import javax.validation.constraints.NotBlank;

public class RefreshTokenRequest {
	@NotBlank
	private String uid;
	@NotBlank
	private String refreshToken;

	
	
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

	
}
