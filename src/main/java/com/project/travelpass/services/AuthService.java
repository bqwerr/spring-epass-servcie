package com.project.travelpass.services;

import java.time.Instant;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.travelpass.dto.LoginRequest;
import com.project.travelpass.dto.RefreshTokenRequest;
import com.project.travelpass.dto.RegisterRequest;
import com.project.travelpass.model.Userr;
import com.project.travelpass.repository.UserRepository;
import com.project.travelpass.security.JwtProvider;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private RefreshTokenService refreshTokenService;
    
    public void signup(RegisterRequest registerRequest) {
        Userr user = new Userr();
        user.setUid(registerRequest.getUid());
        user.setName(registerRequest.getName());
        user.setPhone(registerRequest.getPhone());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setState(registerRequest.getState());
        user.setDistrict(registerRequest.getDistrict());
        user.setCreated(Instant.now()); 
        user.setActive(true);
        user.setAdmin(true);
        userRepository.save(user);
    }
    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUid(),
                loginRequest.getPassword()));
        //System.out.println(authenticate);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String authenticationToken = jwtProvider.generateToken(authenticate);
        return new AuthenticationResponse(authenticationToken, loginRequest.getUid(), 
        		refreshTokenService.generateRefreshToken().getToken(), Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()));
   
    }
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }
	public AuthenticationResponse refreshToken(@Valid RefreshTokenRequest refreshTokenRequest) {
		 refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
		 
		 String token = jwtProvider.generateTokenForRefreshTokenWithUid(refreshTokenRequest.getUid());
		 
		 return new AuthenticationResponse(token, refreshTokenRequest.getUid(), 
				 refreshTokenRequest.getRefreshToken(), Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()));
	}
}