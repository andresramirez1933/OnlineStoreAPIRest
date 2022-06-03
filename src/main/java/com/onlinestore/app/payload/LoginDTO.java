package com.onlinestore.app.payload;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@ApiModel(description = "Log in model info" )
@Data
public class LoginDTO {

    @NotEmpty(message = "Username or email must not be empty")
    @ApiModelProperty(value = "User username or email")
    private String usernameOrEmail;

    @NotEmpty(message = "Password must not be empty")
    @ApiModelProperty(value = "User password")
    private String password;
}
