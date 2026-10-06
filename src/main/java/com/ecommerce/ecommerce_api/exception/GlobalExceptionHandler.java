package com.ecommerce.ecommerce_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handleException(Exception e){
        StandardError erro = new StandardError(500, "Ocorreu um erro Interno no servidor");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }



}
