package com.ecommerce.AccountService.CustomValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class Mobile implements ConstraintValidator<MobileValidation,String> {
    String regex = "^[0-9]+$";
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.matches(regex,value);
    }
}
