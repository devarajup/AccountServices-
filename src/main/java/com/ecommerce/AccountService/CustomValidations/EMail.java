package com.ecommerce.AccountService.CustomValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EMail implements ConstraintValidator<EMailValidation,String> {
    String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";



    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.matches(regex,value);
    }
}
