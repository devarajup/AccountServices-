package com.ecommerce.AccountService.CustomizedExceptionHandling.Exceptions;

public class UserNotFondException extends  RuntimeException{
    public UserNotFondException() {
    }
    public UserNotFondException(String message) {
        super(message);
    }
}
