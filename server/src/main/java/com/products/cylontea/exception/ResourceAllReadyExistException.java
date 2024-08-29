package com.products.cylontea.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceAllReadyExistException extends RuntimeException {


    public ResourceAllReadyExistException(String message) {
        super(message);
    }

}
