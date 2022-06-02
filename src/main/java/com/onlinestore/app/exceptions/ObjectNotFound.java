package com.onlinestore.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ObjectNotFound extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ObjectNotFound(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s is not found with %s: %s ", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }


}
