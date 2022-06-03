package com.onlinestore.app.payload;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "AuthResponse model info")
public class JwtAuthResponse {

    @ApiModelProperty(value = "Access token")
    private String accessToken;
    @ApiModelProperty(value = "Token type")
    private String tokenType;

    public JwtAuthResponse(String accessToken) {
        this.accessToken = accessToken;
        tokenType = "Bearer";
    }
}
