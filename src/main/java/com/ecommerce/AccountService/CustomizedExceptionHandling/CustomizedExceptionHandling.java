package com.ecommerce.AccountService.CustomizedExceptionHandling;

import com.ecommerce.AccountService.CustomizedExceptionHandling.Exceptions.DuplicateException;
import com.ecommerce.AccountService.CustomizedExceptionHandling.Exceptions.UserNotFondException;
import com.ecommerce.AccountService.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
@RestControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFondException.class)
    public ResponseEntity<ExceptionResponse> UserNotFondHandleExceptions(Exception exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage(exception.getMessage());
        System.out.println(response.getMessage());
        return     new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ExceptionResponse> duplicateHandleExceptions(Exception exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage(exception.getMessage());
        System.out.println(response.getMessage());
        return     new ResponseEntity<ExceptionResponse>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }


}