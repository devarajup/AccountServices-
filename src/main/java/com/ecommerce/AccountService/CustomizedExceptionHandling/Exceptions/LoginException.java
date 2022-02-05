package com.ecommerce.AccountService.CustomizedExceptionHandling.Exceptions;

public class LoginException  extends  RuntimeException{

    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }
}
