package com.kevin.spring.security.postgresql.payload.response;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String phoneNumber;
    private String username;
    private String email;
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String phoneNumber, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

}
