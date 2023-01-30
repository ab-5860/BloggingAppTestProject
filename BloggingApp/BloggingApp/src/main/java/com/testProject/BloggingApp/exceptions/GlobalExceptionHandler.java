package com.testProject.BloggingApp.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<Map<Object, Object>> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        Map<Object, Object> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND);
        response.put("success", false);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
