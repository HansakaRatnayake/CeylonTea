package com.products.cylontea.advisor;

import com.products.cylontea.dto.StandardResponse;
import com.products.cylontea.exception.ResourceAlreadyExistException;
import com.products.cylontea.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(ResourceNotFoundException ex){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Error",ex), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<StandardResponse> handleAlreadyExistException(ResourceAlreadyExistException ex){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(409,"Error",ex), HttpStatus.CONFLICT
        );
    }
}
