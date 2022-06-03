package com.onlinestore.app.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@ApiModel(description = "Sign up model info")
public class SignUpDTO {

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must have an email format")
    @ApiModelProperty(value = "User email")
    private String email;

    @NotEmpty(message = "Name must not be empty")
    @ApiModelProperty(value = "User name")
    private String name;

    @NotEmpty(message = "Password must not be empty")
    @ApiModelProperty(value = "User password")
    private String password;

    @NotEmpty(message = "Username must not be empty")
    @ApiModelProperty(value = "User username")
    private String username;
}
