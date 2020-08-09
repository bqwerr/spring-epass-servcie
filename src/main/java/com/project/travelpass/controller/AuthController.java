package com.project.travelpass.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.travelpass.dto.LoginRequest;
import com.project.travelpass.dto.RefreshTokenRequest;
import com.project.travelpass.dto.RegisterRequest;
import com.project.travelpass.services.AuthService;
import com.project.travelpass.services.AuthenticationResponse;
import com.project.travelpass.services.RefreshTokenService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    private RefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
    
    @PostMapping("refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
    	return authService.refreshToken(refreshTokenRequest);
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
	    refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
	    return ResponseEntity.status(HttpStatus.OK).body("Refresh Token Deleted Successfully!!");
    }
    
}