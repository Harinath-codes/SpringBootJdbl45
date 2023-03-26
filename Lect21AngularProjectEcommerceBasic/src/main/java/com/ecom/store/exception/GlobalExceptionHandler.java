package com.ecom.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFound.class)
    public ResponseEntity recordNotFound(RecordNotFound ex){
        Map<String,String> map = new HashMap<>();
        map.put("message",ex.getMessage());
        return new ResponseEntity(map, HttpStatus.NOT_FOUND);
    }
}
