package dev.ruka.restaurantbookingsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> businessExceptionHandler(BusinessException e){
        String responseBody = e.getMessage();
        return ResponseEntity.badRequest().body(responseBody);
    }
}
