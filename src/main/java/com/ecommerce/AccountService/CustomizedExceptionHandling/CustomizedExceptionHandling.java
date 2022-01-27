package com.ecommerce.AccountService.CustomizedExceptionHandling;

import com.ecommerce.AccountService.CustomizedExceptionHandling.Exceptions.UserNotFondException;
import com.ecommerce.AccountService.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFondException.class)
    public ResponseEntity<Object> UserNotFondHandleExceptions(UserNotFondException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage(exception.getMessage());

        return     new ResponseEntity<Object>(response,HttpStatus.UNAUTHORIZED);
    }


}