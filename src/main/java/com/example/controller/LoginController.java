package com.example.controller;

import com.example.jwt.JWTConfigurer;
import com.example.jwt.TokenProvider;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/login")
public class LoginController {

    private AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    public LoginController(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }
    @PostMapping
    public ResponseEntity login (Authentication authentication, HttpServletResponse response) {
        String jwt = tokenProvider.createToken(authentication);
        response.addHeader(JWTConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return ResponseEntity.ok(new JWTToken(jwt));
    }


    static class JWTToken {

        private String idToken;

        JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }
}