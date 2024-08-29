package com.products.cylontea.adviser;


import com.products.cylontea.dto.StandardResponse;
import com.products.cylontea.exception.ResourceAllReadyExistException;
import com.products.cylontea.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomeExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardResponse> CustomeExceptionHandler(ResourceNotFoundException e) {

        return new ResponseEntity<>(new StandardResponse(404,e.getMessage(),e)
                , HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ResourceAllReadyExistException.class)
    public ResponseEntity<StandardResponse> CustomeExceptionHandler(ResourceAllReadyExistException e) {

        return new ResponseEntity<>(new StandardResponse(409,e.getMessage(),e)
                , HttpStatus.CONFLICT);

    }
}
