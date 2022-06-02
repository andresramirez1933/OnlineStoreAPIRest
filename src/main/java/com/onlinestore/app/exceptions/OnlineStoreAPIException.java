package com.onlinestore.app.exceptions;

import org.springframework.http.HttpStatus;

public class OnlineStoreAPIException  extends RuntimeException{

    private HttpStatus status;
    private String message;

    public OnlineStoreAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public OnlineStoreAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
