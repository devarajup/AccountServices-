package com.ecommerce.AccountService.CustomizedExceptionHandling.Exceptions;

public class DuplicateException extends  RuntimeException{
    public DuplicateException() {
    }

    public DuplicateException(String message) {
        super(message);
    }
}
