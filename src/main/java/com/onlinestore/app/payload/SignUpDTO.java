package com.onlinestore.app.payload;

import lombok.Data;

@Data
public class SignUpDTO {

    private String email;
    private String name;
    private String password;
    private String username;
}
