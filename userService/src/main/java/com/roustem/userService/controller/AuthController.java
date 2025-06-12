package com.roustem.userService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import com.roustem.userService.core.security.JwtProviderServiceImpl;
import com.roustem.userService.entity.dto.UserLoginRequestDto;

import java.util.Map;

@RestController
@RequestMapping("/api/user/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtProviderServiceImpl jwtService; // You should have this to generate the token

  
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequestDto request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
                
            );

            String token = jwtService.generateToken(authentication); // implement this
            return ResponseEntity.ok(Map.of("token", token));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(403).body("Invalid email or password");
        }
    }
}
