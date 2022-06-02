package com.onlinestore.app.payload;


import lombok.Data;

@Data

public class JwtAuthResponse {

    private String accessToken;
    private String tokenType;

    public JwtAuthResponse(String accessToken) {
        this.accessToken = accessToken;
        tokenType = "Bearer";
    }
}
