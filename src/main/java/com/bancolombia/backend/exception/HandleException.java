package com.bancolombia.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(MyHandleException.class)
    public ResponseEntity<Object> handleMyException(MyHandleException ex){
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }

    public ResponseEntity<Object> handleException(Exception ex){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("SYSTEM ERROR:" +ex.getMessage());

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity handleValidationException(MethodArgumentNotValidException ex){
        List<String> listError = new ArrayList<>();
        for(FieldError error: ex.getBindingResult().getFieldErrors()) {
            listError.add("""
                    %s filed [%s] error %s 
                    """.formatted(error.getObjectName(),error.getField(),error.getDefaultMessage()));


        }
        return ResponseEntity.badRequest().body(listError);
    }
}
