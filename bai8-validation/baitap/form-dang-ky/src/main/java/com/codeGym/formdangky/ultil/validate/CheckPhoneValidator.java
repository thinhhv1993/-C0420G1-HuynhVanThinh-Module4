package com.codegym.formdangky.ultil.validate;


import com.codegym.formdangky.model.Customer;
import com.codegym.formdangky.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CheckPhoneValidator implements ConstraintValidator<CheckPhone, String> {

    @Override
    public void initialize(CheckPhone constraintAnnotation) {
        System.out.println("Class 2 initialized!");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.length()>11 || value.length()<10){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "key value cannot be null or empty")
                    .addConstraintViolation();
            return false;
        }
        if (!value.startsWith("0")){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "key value cannot be null or empty")
                    .addConstraintViolation();
            return false;
        }
        if (!value.matches("(^$|[0-9]*$)")){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "key value cannot be null or empty")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
