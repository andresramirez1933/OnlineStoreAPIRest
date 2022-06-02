package com.onlinestore.app.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class OnlineStoreException extends RuntimeException{

    private HttpStatus httpStatus;
    private String message;


}
